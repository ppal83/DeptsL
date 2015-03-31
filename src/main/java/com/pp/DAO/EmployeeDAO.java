package com.pp.DAO;

import java.util.List;

import com.pp.model.Employee;

public interface EmployeeDAO {

    void addEmployee(Employee emp);
    void deleteEmployee(Employee emp);
    void updateEmployee(Employee emp);
    void deleteEmployeeById(int id);
    void deleteEmployeesByDeptId(int deptId);
    Employee getEmployeeById(int id);
    List<Employee> getEmployeesByDeptId(int deptId);
    List<Employee> getAllEmployees();

}
