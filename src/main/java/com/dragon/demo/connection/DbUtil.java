package com.dragon.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ljn
 * @date 2019/3/28.
 */
public class DbUtil {

    private static final String driver = "com.mysql.jdbc.Driver";

    private static final String url = "jdbc:mysql://120.78.170.24:3306/test";

    private static final String username = "root";

    private static final String password = "root";

    private static Connection conn = null;

    /**
     * 加锁防止线程1关闭线程2的连接
     * @return
     */
    public static synchronized Connection getConnection() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static synchronized void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn1 = DbUtil.getConnection();
        Connection conn2 = DbUtil.getConnection();
        System.out.println(conn1);
        System.out.println(conn2);
        System.out.println(conn1 == conn2);
    }



}
