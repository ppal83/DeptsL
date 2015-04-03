package com.pp.listeners;

import com.pp.connection.DBCPDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(DBCPDataSourceFactory.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        BasicDataSource ds = DBCPDataSourceFactory.getDataSource();

        try {
            ds.close();
            logger.info("DS connections were closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}