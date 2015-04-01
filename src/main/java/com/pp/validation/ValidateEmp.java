package com.pp.validation;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.DAO.EmployeeDAO;
import com.pp.model.Employee;
import java.util.List;

public class ValidateEmp {

    private static final EmpErrorsBean empBean = new EmpErrorsBean();

    private static final DAOFactory daoFactory = DAOFactory.getInstance();
    private static final DeptDAO deptDAO = daoFactory.getDeptDAO();
    private static final EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();

    public static EmpErrorsBean validate(Employee emp) {

        Employee empDb = null;
        int empId = emp.getId();
        List<Employee> empsList = employeeDAO.getAllEmployees();

        //new employee
        if (empId == 0) {
            for (Employee employee : empsList) {
                if ( emp.getName().equals(employee.getName()) )
                    empBean.setName("Employee with this name already exists");
                    empBean.setValid(false);
            }
        }


        if (empId != 0) {
            empDb = employeeDAO.getEmployeeById(empId);
        }



        System.err.println("Validating:: " + empBean);


        return empBean;
    }

}
