package com.pp.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.pp.DAO.DeptDAO;
import com.pp.connection.DBCPDataSourceFactory;
import com.pp.model.Dept;
import com.pp.util.JDBCUtil;
import org.apache.log4j.Logger;

public class DeptDAOImpl implements DeptDAO {

    private static final Logger logger = Logger.getLogger(DeptDAOImpl.class);

    private static final String ADD_QUERY = "INSERT INTO dept (name) VALUE (?)";
    private static final String DELETE_QUERY = "DELETE FROM dept WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE dept SET id = ?, name = ? WHERE id = ?";
    private static final String GET_QUERY = "SELECT * FROM dept WHERE id = ?";
    private static final String GET_ALL_QUERY = "SELECT * FROM dept ORDER BY id";

    @Override
    public void addDept(Dept dept) {
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(ADD_QUERY)) {
                stat.setString(1, dept.getName());
                int num = stat.executeUpdate();
                logger.debug(num + " row succefully added");
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }

    @Override
    public void deleteDept(Dept dept) {
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(DELETE_QUERY)) {
                stat.setInt(1, dept.getId());
                int num = stat.executeUpdate();
                logger.debug(num + " row succefully deleted");
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }

    @Override
    public void updateDept(Dept dept) {
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(UPDATE_QUERY)) {
                stat.setInt(1, dept.getId());
                stat.setString(2, dept.getName());
                stat.setInt(3, dept.getId());
                int num = stat.executeUpdate();
                logger.debug(num + " row succefully updated");
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }

    @Override
    public void deleteDeptById(int id) {
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(DELETE_QUERY)) {
                stat.setInt(1, id);
                int num = stat.executeUpdate();
                logger.debug(num + " row succefully deleted");
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
    }

    @Override
    public Dept getDeptById(int id) {
        Dept dept = null;
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(GET_QUERY)) {
                stat.setInt(1, id);
                try (ResultSet rs = stat.executeQuery()) {
                    rs.next();
                    String name = rs.getString(2);
                    dept = new Dept(name);
                    dept.setId(id);
                }
                logger.debug(dept + " was fetched from db");
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
        return dept;
    }

    @Override
    public List<Dept> getAllDepts() {
        List<Dept> deptsList = new ArrayList<>();
        try (Connection conn = DBCPDataSourceFactory.getDataSource().getConnection()) {
            try (PreparedStatement stat = conn.prepareStatement(GET_ALL_QUERY)) {
                try (ResultSet rs = stat.executeQuery()) {
                    while (rs.next()) {
                        String name = rs.getString(2);
                        Dept dept = new Dept(name);
                        int id = rs.getInt(1);
                        dept.setId(id);
                        deptsList.add(dept);
                    }
                    logger.debug(deptsList + " list was fetched from db");
                }
            }
        } catch (SQLException e) {
            JDBCUtil.printSQLException(e);
        }
        return deptsList;
    }
}