package com.pp.connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSourceFactory {

    private static BasicDataSource ds = null;

    public static void createDataSource(String drv, String url,
                                        String usr, String pwd) {
        if (ds == null) {
            ds = new BasicDataSource();
            ds.setDriverClassName(drv);
            ds.setUrl(url);
            ds.setUsername(usr);
            ds.setPassword(pwd);
        }
    }

    public static BasicDataSource getDataSource(){
        return ds != null ? ds : null;
    }
}
