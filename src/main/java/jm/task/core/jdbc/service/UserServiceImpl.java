package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final boolean runDaoHibernate = false;
    private final UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        if (runDaoHibernate) {
            userDaoHibernate.createUsersTable();
        } else {
            userDaoJDBC.createUsersTable();
        }
    }

    public void dropUsersTable() {
        if (runDaoHibernate) {
            userDaoHibernate.dropUsersTable();
        } else {
            userDaoJDBC.dropUsersTable();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        if (runDaoHibernate) {
            userDaoHibernate.saveUser(name, lastName, age);
        } else {
            userDaoJDBC.saveUser(name, lastName, age);
        }
    }

    public void removeUserById(long id) {
        if (runDaoHibernate) {
            userDaoHibernate.removeUserById(id);
        } else {
            userDaoJDBC.removeUserById(id);
        }
    }

    public List<User> getAllUsers() {
        if (runDaoHibernate) {
            return userDaoHibernate.getAllUsers();
        } else {
            return userDaoJDBC.getAllUsers();
        }
    }

    public void cleanUsersTable() {
        if (runDaoHibernate) {
            userDaoHibernate.cleanUsersTable();
        } else {
            userDaoJDBC.cleanUsersTable();
        }
    }
}
