package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Bruce", "Banner", (byte)52);
        userService.saveUser("Steve", "Rogers", (byte)102);
        userService.saveUser("Nicholas", "Fury", (byte)69);
        userService.saveUser("Clinton", "Barton", (byte)50);
        List<User> users = userService.getAllUsers();
        for (User u : users){
            System.out.println(u);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
