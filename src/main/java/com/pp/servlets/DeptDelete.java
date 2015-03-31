package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
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

@WebServlet(name = "DeptDelete", urlPatterns = "/dept/delete")
public class DeptDelete extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DeptDelete.class);

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();
    private static final EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/depts.jsp");
        int id = Integer.parseInt(req.getParameter("deptId"));
        employeeDAO.deleteEmployeesByDeptId(id);
        deptDAO.deleteDeptById(id);
        List<Dept> deptsList = deptDAO.getAllDepts();
        req.setAttribute("deptsList", deptsList);
        logger.info("Forwarding to depts.jsp");

        rd.forward(req, resp);
    }
}
