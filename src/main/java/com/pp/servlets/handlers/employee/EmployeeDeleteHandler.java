package com.pp.servlets.handlers.employee;

import com.pp.DAO.EmployeeDAO;
import com.pp.servlets.handlers.Handler;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class EmployeeDeleteHandler implements Handler {

    private static final Logger logger = Logger.getLogger(EmployeeDeleteHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        EmployeeDAO employeeDAO = (EmployeeDAO) DAOs.get("employeeDAO");

        int id = Integer.parseInt(req.getParameter("id"));
        int deptId = employeeDAO.getEmployeeById(id).getDeptId();
        employeeDAO.deleteEmployeeById(id);
        logger.info("Forwarding to EmployeeListHandler");

        resp.sendRedirect(req.getContextPath() + "/emplist.html?deptId=" + deptId);
    }
}
