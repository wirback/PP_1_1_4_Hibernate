package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS usersTable
                    (id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(50),
                    lastname VARCHAR(50),
                    age TINYINT
                    )"""
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                CREATE TABLE IF NOT EXISTS usersTable
                (id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(50),
                lastname VARCHAR(50),
                age TINYINT
                )""")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("""
                    DROP TABLE IF EXISTS usersTable
                    """
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                DROP TABLE IF EXISTS usersTable
                """)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                INSERT INTO usersTable(name, lastname, age) VALUE(?,?,?)
                """)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.printf("User с именем - %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate(String.format("""
                    DELETE FROM usersTable WHERE %s
                    """, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try (PreparedStatement preparedStatement = connection.prepareStatement("""
                DELETE FROM usersTable WHERE ?
                """)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        /*try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usersTable");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usersTable")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void cleanUsersTable() {
        /*try (Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM usersTable");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usersTable")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
