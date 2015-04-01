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
import java.util.List;
import java.util.Map;

public class DeptListHandler implements Handler {

    private static final Logger logger = Logger.getLogger(DeptListHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                            Map<String, Object> DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");
        List<Dept> deptsList = deptDAO.getAllDepts();
        req.setAttribute("deptsList", deptsList);

        logger.debug("Forwarding to depts.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/depts.jsp");
        rd.forward(req, resp);
    }
}
