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
import java.util.List;

@WebServlet(name = "EmployeeAddShowForm", urlPatterns = "/employee/add")
public class EmployeeAddShowForm extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EmployeeAddShowForm.class);
    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> deptsList = deptDAO.getAllDepts();
        req.setAttribute("deptsList", deptsList);

        logger.info("Forwarding to employee_add.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/employee_add.jsp");
        rd.forward(req, resp);
    }


}
