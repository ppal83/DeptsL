package com.pp.servlets.handlers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface Handler {

    void handle(HttpServletRequest req, HttpServletResponse resp,
                        Map<String, Object> DAOs) throws ServletException, IOException;

}
