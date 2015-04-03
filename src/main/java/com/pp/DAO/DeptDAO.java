package com.pp.DAO;

import java.util.List;

import com.pp.model.Dept;

public interface DeptDAO {

    int addDept(Dept dept);
    int deleteDept(Dept dept);
    void updateDept(Dept dept);
    int deleteDeptById(int id);
    Dept getDeptById(int id);
    List<Dept> getAllDepts();

}
