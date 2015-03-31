package com.pp.DAO;

import java.util.List;

import com.pp.model.Dept;

public interface DeptDAO {

    void addDept(Dept dept);
    void deleteDept(Dept dept);
    void updateDept(Dept dept);
    void deleteDeptById(int id);
    Dept getDeptById(int id);
    List<Dept> getAllDepts();

}
