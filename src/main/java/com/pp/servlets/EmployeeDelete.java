package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.EmployeeDAO;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeDelete", urlPatterns = "/employee/delete")
public class EmployeeDelete extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeptDelete.class);

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int deptId = employeeDAO.getEmployeeById(id).getDeptId();
        employeeDAO.deleteEmployeeById(id);
        logger.info("Forwarding to EmployeeList");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/employee/list?deptId=" + deptId);
        rd.forward(req, resp);
    }
}