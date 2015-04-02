package com.pp.servlets;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.servlets.handlers.*;
import com.pp.servlets.handlers.dept.*;
import com.pp.servlets.handlers.employee.*;
import com.pp.servlets.handlers.employee.EmployeeListHandler;
import com.pp.servlets.handlers.dept.DeptListHandler;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "DispatcherServlet", urlPatterns = "*.html")
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(DispatcherServlet.class);

    private static Map<String, Object> DAOs;

    private static final Map<String, Handler> handlers = new HashMap<>();

    @Override
    public void init() throws ServletException {
        logger.debug("Dispatcher servlet initialized");

        DAOFactory daoFactory = DAOFactory.getInstance();
        DeptDAO deptDAO = daoFactory.getDeptDAO();
        EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
        DAOs = new HashMap<>(2);
        DAOs.put("deptDAO", deptDAO);
        DAOs.put("employeeDAO", employeeDAO);

        logger.debug("Registering handlers");
        handlers.put("/emplist.html", new EmployeeListHandler());
        handlers.put("/deptlist.html", new DeptListHandler());
        handlers.put("/empdel.html", new EmployeeDeleteHandler());
        handlers.put("/deptdel.html", new DeptDeleteHandler());
        handlers.put("/deptedit_form.html", new DeptEditFormHandler());
        handlers.put("/deptedit.html", new DeptUpdateHandler());
        handlers.put("/empedit_form.html", new EmployeeEditFormHandler());
        handlers.put("/empedit.html", new EmployeeUpdateHandler());
        handlers.put("/deptadd_form.html", new DeptAddFormHandler());
        handlers.put("/deptadd.html", new DeptUpdateHandler());
        handlers.put("/empadd_form.html", new EmployeeAddForm());
        handlers.put("/empadd.html", new EmployeeUpdateHandler());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI().substring(req.getContextPath().length());
        logger.debug("Request received: " + path);

        logger.debug("Matching appropriate handler");
        Handler handler = handlers.get(path);
        if (handler != null) {
            logger.debug("Handler found: " + handler.getClass().getSimpleName());
            handler.handle(req, resp, DAOs);
        } else {
            logger.debug("Didn't found handler");
        }

    }

    @Override
    public void destroy() {
        logger.debug("Dispatcher servlet destroyed");
    }
}
