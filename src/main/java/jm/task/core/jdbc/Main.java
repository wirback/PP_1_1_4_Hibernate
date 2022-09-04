package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        User user_1 = new User("Name_user_1", "LastName_user_1", (byte) 10);
        User user_2 = new User("Name_user_2", "LastName_user_2", (byte) 20);
        User user_3 = new User("Name_user_3", "LastName_user_3", (byte) 30);
        User user_4 = new User("Name_user_4", "LastName_user_4", (byte) 40);

        userService.createUsersTable();

        userService.saveUser(user_1.getName(), user_1.getLastName(), user_1.getAge());
        userService.saveUser(user_2.getName(), user_2.getLastName(), user_2.getAge());
        userService.saveUser(user_3.getName(), user_3.getLastName(), user_3.getAge());
        userService.saveUser(user_4.getName(), user_4.getLastName(), user_4.getAge());

        List.of(userService.getAllUsers()).forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
