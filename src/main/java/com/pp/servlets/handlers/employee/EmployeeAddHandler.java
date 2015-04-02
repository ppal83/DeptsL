package com.pp.servlets.handlers.employee;

import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.model.Dept;
import com.pp.model.Employee;
import com.pp.servlets.handlers.Handler;
import com.pp.servlets.handlers.util.EmployeeFromReq;
import com.pp.validation.employee.EmployeeValidator;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EmployeeAddHandler implements Handler {

    private static final Logger logger = Logger.getLogger(EmployeeAddHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");
        EmployeeDAO employeeDAO = (EmployeeDAO) DAOs.get("employeeDAO");

        EmployeeValidator validator = new EmployeeValidator();

        int deptId = Integer.parseInt(req.getParameter("deptId"));

        if ( validator.validate(req) ) {
            Employee emp = EmployeeFromReq.create(req);
            employeeDAO.addEmployee(emp);
            logger.debug("Forwarding to EmployeeListHandler");
            resp.sendRedirect(req.getContextPath() + "/emplist.html?deptId=" + deptId);
        } else {
            req.setAttribute("errorsBean", validator.getEmpErrBean());
            req.setAttribute("employee", validator.getEmpInputedBean());
            req.setAttribute("id", deptId);

            List<Dept> deptsList = deptDAO.getAllDepts();
            req.setAttribute("deptsList", deptsList);

            logger.debug("Validation failed. Returning employee_add.jsp");

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/employee_add.jsp");
            rd.include(req, resp);
        }
    }
}