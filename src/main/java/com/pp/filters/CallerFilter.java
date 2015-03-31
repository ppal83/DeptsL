package com.pp.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CallerFilter implements Filter {

    private static final Logger logger = Logger.getLogger(CallerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.warn(request.getAttribute("javax.servlet.forward.request_uri"));
        logger.warn("getrRequestURI() " + ((HttpServletRequest) request).getRequestURI());
        logger.warn("getQueryString() " + ((HttpServletRequest) request).getQueryString());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
