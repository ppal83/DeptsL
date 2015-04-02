package com.pp;

import com.pp.DAO.DAOFactory;
import com.pp.DAO.DeptDAO;
import com.pp.connection.DBCPDataSourceFactory;
import com.pp.model.Dept;
import com.pp.util.JDBCUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.*;

public class DeptDAOTest {

    private static DAOFactory daoFactory;
    private static DeptDAO deptDAO;

    //test queries
    private static final String GET_QUERY = "SELECT * FROM dept WHERE name = ?";

    @BeforeClass
    public static void setUp() {
        daoFactory = DAOFactory.getInstance();
        deptDAO = daoFactory.getDeptDAO();

        //------------------------------------
        Properties props = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream in = classLoader.getResourceAsStream("db.properties") ) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        try ( InputStream in = Files.newInputStream(Paths.get("db.properties")) ) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    @Test
    public void testAddDept() {

        //adding dept to db
        Dept dept = new Dept("testDept");
        deptDAO.addDept(dept);

        Dept deptDb = null;

        //fetching dept from db
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(GET_QUERY)) {
                stat.setString(1, "testDept");
                try (ResultSet rs = stat.executeQuery()) {
                    while (rs.next()) {
                        String nameDb = rs.getString(2);
                        deptDb = new Dept(nameDb);
                    }
                }
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }

        assertEquals(dept.getName(), deptDb.getName());

    }

    @AfterClass
    public static void tearDown() {
        daoFactory = null;
        deptDAO = null;
    }

}
