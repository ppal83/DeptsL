package com.pp.servlets.handlers.dept;

import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import com.pp.servlets.handlers.Handler;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DeptEditHandler implements Handler {

    private static final Logger logger = Logger.getLogger(DeptEditHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Dept dept = new Dept(name);
        dept.setId(id);
        deptDAO.updateDept(dept);
        logger.info("Forwarding to DeptListHandler");

        resp.sendRedirect(req.getContextPath() + "/deptlist.html");
    }
}
