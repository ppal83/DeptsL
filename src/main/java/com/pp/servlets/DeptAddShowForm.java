package com.pp.servlets;

import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptAddShowForm", urlPatterns = "/dept/add")
public class DeptAddShowForm extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeptAddShowForm.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Forwarding to dept_add.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/dept_add.jsp");
        rd.forward(req, resp);
    }


}
