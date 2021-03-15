package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String url = "jdbc:mysql://localhost:3306/test";
    private final String user = "root";
    private final String password = "test";
    private Connection connection;
    private SessionFactory sessionFactory;
    private static Util util;
    private Util() {}
    public static Util getUtil() throws SQLException {
        if (util == null) {
            util = new Util();
        }
        return util;
    }
    public Connection getConnection() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection( url, user,password);
        }
        return connection;
    }
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try {
                Configuration config = new Configuration();
                config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                config.setProperty("hibernate.connection.url", url);
                config.setProperty("hibernate.connection.username", user);
                config.setProperty("hibernate.connection.password", password);
                config.addAnnotatedClass(User.class);
                sessionFactory = config.buildSessionFactory();
            } catch (HibernateException e) {
                throw e;
            }
        }
        return sessionFactory;
    }

}
