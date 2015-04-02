package com.pp.servlets.handlers.util;

import com.pp.model.Dept;

import javax.servlet.http.HttpServletRequest;

public class DeptFromReq {

    public static Dept create(HttpServletRequest req) {
        String name = req.getParameter("name");

        return new Dept(name);
    }
}
