package com.pp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pyjama on 17.03.15.
 */
@WebServlet(name = "controller", urlPatterns = {"/one", "/two"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        PrintWriter out= resp.getWriter();
        out.print("<font color=red>GANGNAM STYLE</font>");
        out.println("<br />");
        rd.include(req, resp);
        out.println();
        out.println(true);
        out.println("<font color=red>GANGNAM STYLE</font>");
        out.println("<font color=blue>OPA-PA</font>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
