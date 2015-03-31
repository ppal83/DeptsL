package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeptAddAction", urlPatterns = "/dept/add.do")
public class DeptAddAction extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeptAddAction.class);

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = new Dept(req.getParameter("name"));
        deptDAO.addDept(dept);
        logger.info("Forwarding to DeptList");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/dept/list");
        rd.forward(req, resp);
    }
}
