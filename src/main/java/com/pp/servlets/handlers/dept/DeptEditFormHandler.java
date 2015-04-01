package com.pp.servlets.handlers.dept;

import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import com.pp.servlets.handlers.Handler;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DeptEditFormHandler implements Handler {

    private static final Logger logger = Logger.getLogger(DeptEditFormHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");

        int id = Integer.parseInt(req.getParameter("deptId"));
        Dept dept = deptDAO.getDeptById(id);
        req.setAttribute("dept", dept);
        logger.info("Forwarding to dept_edit.jsp");

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dept_edit.jsp");
        rd.forward(req, resp);
    }
}
