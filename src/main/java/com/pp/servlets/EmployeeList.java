package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.model.Dept;
import com.pp.model.Employee;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeList", urlPatterns = "/employee/list")
public class EmployeeList extends HttpServlet {

    private static final Logger logger = Logger.getLogger(EmployeeList.class);

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();
    private static final EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("deptId"));
        logger.info("request param id = " + id);
        Dept dept = deptDAO.getDeptById(id);
        List<Employee> empsList = employeeDAO.getEmployeesByDeptId(id);
        req.setAttribute("dept", dept);
        req.setAttribute("empsList", empsList);
        logger.info("Forwarding to employees.jsp");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/employees.jsp");
        rd.forward(req, resp);
    }

}