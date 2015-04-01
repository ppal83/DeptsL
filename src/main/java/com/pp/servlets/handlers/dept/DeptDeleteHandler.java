package com.pp.servlets.handlers.dept;

import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.model.Dept;
import com.pp.servlets.handlers.Handler;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DeptDeleteHandler implements Handler {

    private static final Logger logger = Logger.getLogger(DeptDeleteHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");
        EmployeeDAO employeeDAO = (EmployeeDAO) DAOs.get("employeeDAO");
        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");

        int id = Integer.parseInt(req.getParameter("deptId"));
        employeeDAO.deleteEmployeesByDeptId(id);
        deptDAO.deleteDeptById(id);
        List<Dept> deptsList = deptDAO.getAllDepts();
        req.setAttribute("deptsList", deptsList);
        logger.info("Forwarding to depts.jsp");

        resp.sendRedirect(req.getContextPath() + "/deptlist.html");
    }
}