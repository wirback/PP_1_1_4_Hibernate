package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    // create table
    void createUsersTable();

    // delete table
    void dropUsersTable();

    // read one row
    void saveUser(String name, String lastName, byte age);

    // delete row from id
    void removeUserById(long id);

    // get all row data
    List<User> getAllUsers();

    // delete all row data
    void cleanUsersTable();
}
