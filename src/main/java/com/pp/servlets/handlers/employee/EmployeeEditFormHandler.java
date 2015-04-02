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

public class EmployeeEditFormHandler implements Handler {

    private static final Logger logger = Logger.getLogger(EmployeeEditFormHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        EmployeeDAO employeeDAO = (EmployeeDAO) DAOs.get("employeeDAO");
        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");

        int id = Integer.parseInt(req.getParameter("id"));
        Employee emp = employeeDAO.getEmployeeById(id);
        req.setAttribute("employee", emp);
        List<Dept> deptsList = deptDAO.getAllDepts();
        req.setAttribute("deptsList", deptsList);

        logger.info("Forwarding to employee_edit.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/employee_edit.jsp");
        rd.forward(req, resp);
    }
}
