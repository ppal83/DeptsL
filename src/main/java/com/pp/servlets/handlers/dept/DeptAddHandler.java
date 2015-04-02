package com.pp.servlets.handlers.dept;

import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import com.pp.servlets.handlers.Handler;
import com.pp.servlets.handlers.util.DeptFromReq;
import com.pp.validation.dept.DeptValidator;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class DeptAddHandler implements Handler {

    private static final Logger logger = Logger.getLogger(DeptAddHandler.class);

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp,
                       Map DAOs) throws ServletException, IOException {

        logger.debug("Handling request");

        DeptDAO deptDAO = (DeptDAO) DAOs.get("deptDAO");

        DeptValidator validator = new DeptValidator();

        if ( validator.validate(req) ) {
            Dept dept = DeptFromReq.create(req);
            deptDAO.addDept(dept);
            logger.info("Forwarding to DeptListHandler");
            resp.sendRedirect(req.getContextPath() + "/deptlist.html");
        } else {
            req.setAttribute("errorsBean", validator.getDeptErrBean());
            req.setAttribute("dept", validator.getDeptInputedBean());
            //req.setAttribute("id", deptId);

            logger.debug("Validation failed. Returning dept_add.jsp");

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/dept_add.jsp");
            rd.include(req, resp);
        }


    }
}