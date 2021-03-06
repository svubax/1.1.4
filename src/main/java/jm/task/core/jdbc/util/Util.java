package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password ="test";
    private static Connection connection;
    private static SessionFactory sessionFactory;
    private Util(){}
    public static Connection getConnection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection( url, user,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try {
                Configuration config = new Configuration();
                config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
                config.setProperty("hibernate.connection.username", "root");
                config.setProperty("hibernate.connection.password", "test");
                config.addAnnotatedClass(User.class);
                sessionFactory = config.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
