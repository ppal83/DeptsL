package com.pp.servlets.handlers.util;

import com.pp.model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class EmployeeFromReq {

    public static Employee create(HttpServletRequest req) {
        String name = req.getParameter("name");
        Date birthDate = Date.valueOf(req.getParameter("Birthday"));
        Date hireDate = Date.valueOf(req.getParameter("HireDate"));
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        int deptId = Integer.parseInt(req.getParameter("deptId"));
        int salary = Integer.parseInt( req.getParameter("salary") );

        return new Employee(name, birthDate, hireDate, address, email, deptId, salary);
    }
}
