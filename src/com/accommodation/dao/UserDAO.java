package com.accommodation.dao;

import com.accommodation.bean.User;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.accommodation.util.PasswordMD5.getMD5;

/**
 * @author chanthan
 */
public class UserDAO {
    public void addUser(User user) throws SQLException {
        String query="INSERT INTO user (email, password, first_name, last_name, address, telephone_number, role_id, student_id," +
                "rent_id, is_active) VALUES('"+user.getEmail()+"','"+user.getPassword()+"','"+user.getFirstName()+"'," +
                "'"+user.getLastName()+"','"+user.getAddress()+"','"+user.getTelephoneNumber()+"'," +
                "'"+user.getRoleId()+"','"+user.getStudentId()+"','"+user.getRentId()+"',"+user.isActive()+")";
        DBConnector.executeQuery(query);
    }


    public List<User> getUsers() throws SQLException{
        List<User> userList = new ArrayList<>();
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM user");
        while (rs.next()) {
            userList.add(processSummaryRow(rs));
        }
        return userList;
    }

    public User getUser(int userId) throws SQLException{
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM user WHERE user_id ='"+userId+"'");
        rs.next();
        return processSummaryRow(rs);
    }

    public User getValidateUser(String email, String password) throws SQLException, NoSuchAlgorithmException {
        password = getMD5(password);
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM user WHERE email='"+email+"' AND password='"+password+"'");
        rs.next();
        return processSummaryRow(rs);
    }

    public void updateUser(User user) throws SQLException{
        String query="UPDATE user SET email='"+user.getEmail()+"',password='"+user.getPassword()+"'," +
                "first_name='"+user.getFirstName()+"',last_name='"+user.getLastName()+"',address='"+
                user.getAddress()+"',telephone_number='"+user.getTelephoneNumber()+"',role_id="+user.getRoleId()+
                " ,student_id='"+user.getStudentId()+"',rent_id='"+user.getRentId()+"',is_active="+user.isActive()+
                " WHERE user_id='"+user.getUserId()+"'";
        DBConnector.executeQuery(query);
    }

    public void updateRentId(int propertyId, int userId) throws SQLException{
        String query="UPDATE user SET rent_id='"+propertyId+"' WHERE user_id='"+userId+"'";
        DBConnector.executeQuery(query);
    }

    public User getLastUser() throws SQLException{
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM user ORDER BY user_id DESC LIMIT 1");
        rs.next();
        return processSummaryRow(rs);
    }

    public void deleteUser(int userId) throws SQLException{
        String query="DELETE FROM user WHERE user_id ='"+userId+"'";
        DBConnector.executeQuery(query);
    }

    private static User processSummaryRow(ResultSet rs) throws SQLException {
        User user= new User();
        user.setUserId(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setAddress(rs.getString("address"));
        user.setTelephoneNumber(rs.getString("telephone_number"));
        user.setRoleId(rs.getInt("role_id"));
        user.setStudentId(rs.getString("student_id"));
        user.setRentId(rs.getInt("rent_id"));
        user.setActive(rs.getBoolean("is_active"));
        return user;
    }
}
