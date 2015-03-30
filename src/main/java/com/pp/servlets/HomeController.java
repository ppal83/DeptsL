package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeController", value = "/home", loadOnStartup=1)
public class HomeController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(HomeController.class);

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                                                throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                                throws ServletException, IOException {
       doGet(req, resp);
    }
}
