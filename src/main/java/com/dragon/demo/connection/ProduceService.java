package com.dragon.demo.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ljn
 * @date 2019/3/28.
 */
public class ProduceService {


    public ResultSet execute() throws InterruptedException {
        Connection conn = DbUtil.getConnection();
        ResultSet resultSet = null;
        try {
            conn.setAutoCommit(false);
            PreparedStatement prepared = conn.prepareStatement("select * from t_user limit 10;");
            resultSet = prepared.executeQuery();
            conn.commit();
            System.out.println("query success");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeConnection();
        }
        return resultSet;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            ClientThread clientThread = new ClientThread();
            Thread thread = new Thread(clientThread);
            thread.start();
        }
    }
}
