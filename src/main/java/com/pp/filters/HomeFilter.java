package com.pp.filters;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/index.jsp"})
public class HomeFilter implements Filter {

    private static final Logger logger = Logger.getLogger(HomeFilter.class);
    private static DAOFactory daoFactory = null;
    private static DeptDAO deptDAO = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        daoFactory = DAOFactory.getInstance();
        deptDAO = daoFactory.getDeptDAO();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<Dept> deptList = deptDAO.getAllDepts();
        request.setAttribute("deptsList", deptList);
        logger.info("added deptsList attribute:: " + deptList);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
