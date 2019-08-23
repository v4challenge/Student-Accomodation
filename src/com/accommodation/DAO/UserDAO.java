package com.accommodation.DAO;

import com.accommodation.bean.User;

import java.sql.SQLException;

/**
 * @author chanthan
 */
public class UserDAO {
    public void addUser(User user) throws SQLException {
        String query="INSERT INTO user VALUES('"+user.getEmail()+"','"+user.getPassword()+"','"+user.getFirst_name()+"')";
        DBConnector.executeQuery(query);
    }
}
