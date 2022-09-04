package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String USER_NAME = "user";
    private static final String PASSWORD = "Password-123456";

    public static Connection getConnectionJDBC() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getConnectionHibernate() {
        SessionFactory sessionFactory = null;

        try {
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.url", URL);
            properties.setProperty("hibernate.connection.driver_class", DRIVER);
            properties.setProperty("hibernate.connection.username", USER_NAME);
            properties.setProperty("hibernate.connection.password", PASSWORD);
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.setProperty("hibernate.current_session_context_class", "thread");

            sessionFactory = new Configuration()
                    .addProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }
}
