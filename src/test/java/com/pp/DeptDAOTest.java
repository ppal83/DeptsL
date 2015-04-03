package com.pp;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.model.Dept;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeptDAOTest {

    private static DAOFactory daoFactory;
    private static DeptDAO deptDAO;

    @BeforeClass
    public static void setUp() {
        daoFactory = DAOFactory.getInstance();
        deptDAO = daoFactory.getDeptDAO();
    }

    @Test
    public void testAddDept() {
        Dept dept = new Dept("testDept");
        int testDeptNum = deptDAO.addDept(dept);
        assertTrue("Shouldn't return 0", testDeptNum != 0);

        //deleting test dept
        dept.setId(testDeptNum);
        deptDAO.deleteDept(dept);
    }

    @Test
    public void testDeleteDept() {
        //adding test dept
        Dept dept = new Dept("testDept");
        int testDeptNum = deptDAO.addDept(dept);
        dept.setId(testDeptNum);

        int num = deptDAO.deleteDept(dept);
        assertTrue("Shouldn't return 0", num != 0);
    }

    @Test
    public void testUpdateDept() {
        //adding test dept
        Dept dept = new Dept("testDept");
        int testDeptNum = deptDAO.addDept(dept);
        dept.setId(testDeptNum);

        dept.setName("updatedDept");
        deptDAO.updateDept(dept);

        Dept dbDept = deptDAO.getDeptById(dept.getId());
        assertEquals(dbDept.getName(), "updatedDept");

        //deleting test dept
        deptDAO.deleteDept(dbDept);
    }

    @Test
    public void testDeleteDeptById() {
        //adding test dept
        Dept dept = new Dept("testDept");
        int testDeptNum = deptDAO.addDept(dept);

        int num = deptDAO.deleteDeptById(testDeptNum);
        assertTrue("Shouldn't return 0", num != 0);
    }

    @Test
    public void testGetDeptById() {
        //adding test dept
        Dept dept = new Dept("testDept");
        int testDeptNum = deptDAO.addDept(dept);
        dept.setId(testDeptNum);

        Dept dbDept = deptDAO.getDeptById(dept.getId());
        assertEquals(dbDept.getName(), "testDept");

        //deleting test dept
        deptDAO.deleteDept(dbDept);
    }

    @Test
    public void testGetAllDepts() {
        //adding test depts
        Dept dept1 = new Dept("testDept1");
        int testDept1Num = deptDAO.addDept(dept1);
        dept1.setId(testDept1Num);

        Dept dept2 = new Dept("testDept2");
        int testDept2Num = deptDAO.addDept(dept2);
        dept2.setId(testDept2Num);

        List<Dept> list = deptDAO.getAllDepts();
        assertNotNull(list);

        //deleting test depts
        deptDAO.deleteDept(dept1);
        deptDAO.deleteDept(dept2);
    }

    @AfterClass
    public static void tearDown() {
        daoFactory = null;
        deptDAO = null;
    }

}
