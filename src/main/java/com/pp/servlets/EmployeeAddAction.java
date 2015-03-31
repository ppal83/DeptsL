package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.model.Employee;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EmployeeAddAction", urlPatterns = "/employee/add.do")
public class EmployeeAddAction extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeptAddAction.class);

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();
    private static final EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date birthDate = Date.valueOf(req.getParameter("Birthday"));
        Date hireDate = Date.valueOf(req.getParameter("HireDate"));
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        int dept_id = Integer.parseInt(req.getParameter("dept"));
        int salary = Integer.parseInt(req.getParameter("salary"));

        Employee emp = new Employee(name, birthDate, hireDate, address,
                email, dept_id, salary);
        employeeDAO.addEmployee(emp);
        logger.info("Forwarding to EmployeeList");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/employee/list?deptId=" + dept_id);
        rd.forward(req, resp);
    }
}