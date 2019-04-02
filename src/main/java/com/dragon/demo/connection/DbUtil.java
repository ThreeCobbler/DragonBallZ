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

    /**
     * 可以使用ThreadLocal为每个线程创建一个数据库连接
     * 这样就不会产生并发的问题
     */
    private static ThreadLocal<Connection> localConn = new ThreadLocal<Connection>();

    /**
     * 加锁防止线程1关闭线程2的连接
     * @return
     */
    public static Connection getConnection() {
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            localConn.set(conn);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return localConn.get();
    }

    public static void closeConnection() {
        Connection conn = localConn.get();
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
