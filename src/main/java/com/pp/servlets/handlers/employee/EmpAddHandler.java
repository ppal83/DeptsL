package com.pp.servlets.handlers.employee;

import com.pp.DAO.EmployeeDAO;
import com.pp.model.Employee;
import com.pp.servlets.handlers.Handler;
import com.pp.validation.EmpErrorsBean;
import com.pp.validation.ValidateEmp;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

public class EmpAddHandler implements Handler {

    private static final Logger logger = Logger.getLogger(EmpAddHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        EmpErrorsBean empBean = null;

        EmployeeDAO employeeDAO = (EmployeeDAO) DAOs.get("employeeDAO");

        String name = req.getParameter("name");
        Date birthDate = Date.valueOf(req.getParameter("Birthday"));
        Date hireDate = Date.valueOf(req.getParameter("HireDate"));
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        int dept_id = Integer.parseInt(req.getParameter("dept"));
        int salary = Integer.parseInt(req.getParameter("salary"));

        Employee emp = new Employee(name, birthDate, hireDate, address,
                email, dept_id, salary);

        empBean = ValidateEmp.validate(emp);

        if ( empBean.isValid() ) {
            employeeDAO.addEmployee(emp);
        } else {
            logger.warn("Validation failed!!!");
            req.setAttribute("errorsBean", empBean);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/employee_add.jsp");
            rd.include(req, resp);
            return;
        }

        logger.info("Forwarding to EmpListHandler");

        resp.sendRedirect(req.getContextPath() + "/emplist.html?deptId=" + dept_id);
    }
}