package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "Password-123456";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //System.out.println("Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println("Connection ERROR");
        }

        return connection;
    }
}
