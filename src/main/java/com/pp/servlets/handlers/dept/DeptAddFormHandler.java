package com.pp.servlets.handlers.dept;

import com.pp.servlets.handlers.Handler;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DeptAddFormHandler implements Handler {

    private static final Logger logger = Logger.getLogger(DeptAddFormHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        logger.info("Forwarding to dept_add.jsp");
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dept_add.jsp");
        rd.forward(req, resp);
    }
}