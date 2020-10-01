package main.java.by.epamtc.bobkov.dao.impl;

import main.java.by.epamtc.bobkov.bean.AuthorizationData;
import main.java.by.epamtc.bobkov.bean.RegistrationData;
import main.java.by.epamtc.bobkov.bean.UserData;
import main.java.by.epamtc.bobkov.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String SELECT_USER_BY_LOGIN =
            "SELECT u.user_id, u.user_login, " + "FROM users u " + "WHERE u.user_login=? and u.user_password=? and u.user_role=rol.user_role_id and u.user_rating=rat.user_rating_id;";

    private static final String INSERT_NEW_USERL =
            "INSERT INTO users (user_e-mail, user_phone, user_login, user_password, user_age, user_role) " +
                    "VALUES (?, ?, ?, ?, ?, 1)";


    @Override
    public UserData authorization(AuthorizationData authorizationData) {
        UserData user = null;

        ConnectionProvider customConnectionProvider;
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            customConnectionProvider = ConnectionProvider.getInstance();
            connection = customConnectionProvider.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);


            preparedStatement.setString(1, authorizationData.getLogin());
            preparedStatement.setString(2, authorizationData.getPassword());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String login = resultSet.getString("login");

                System.out.println("id = " + id);
                System.out.println("login = " + login);

            } else {
                System.out.println("USER NOT FOUND");

            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwable) {
                    //
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwable) {
                   //
                }
            }
        }

        return user;
    }

    @Override
    public boolean reegistration(RegistrationData registrationData) {
        return false;
    }
}
