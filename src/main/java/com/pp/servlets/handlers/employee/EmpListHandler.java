package com.pp.servlets.handlers.employee;

import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.model.Dept;
import com.pp.model.Employee;
import com.pp.servlets.handlers.Handler;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EmpListHandler implements Handler {

    private static final Logger logger = Logger.getLogger(EmpListHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                                Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        EmployeeDAO employeeDAO = (EmployeeDAO) DAOs.get("employeeDAO");
        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");

        int id = Integer.parseInt(req.getParameter("deptId"));
        Dept dept = deptDAO.getDeptById(id);
        req.setAttribute("dept", dept);

        List<Employee> empsList = employeeDAO.getEmployeesByDeptId(id);
        req.setAttribute("empsList", empsList);

        logger.debug("Forwarding to employees.jsp");

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/employees.jsp");
        rd.forward(req, resp);
    }
}
