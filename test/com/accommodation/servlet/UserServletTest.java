package com.accommodation.servlet;

import com.accommodation.bean.User;
import com.accommodation.dao.RoleDAO;
import com.accommodation.dao.UserDAO;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.accommodation.util.PasswordMD5.getMD5;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chanthan
 */
class UserServletTest {

    @Test
    void doPost() {
        try {
            User user = new User();
            UserDAO userDAO = new UserDAO();
            user.setEmail("test@teast.com");
            user.setPassword(getMD5("1234"));
            user.setFirstName("tester");
            user.setLastName("chanthan");
            user.setAddress("abc");
            user.setTelephoneNumber("1234567891");
            user.setRoleId(new RoleDAO().getRole().get(0).getRoleId());
            user.setStudentId("stu001");
            user.setRentId(0);
            user.setActive(true);
            //Insert
            userDAO.addUser(user);
            User insertedUser = userDAO.getLastUser();
            assertEquals(user.getEmail(), insertedUser.getEmail());
            //Update
            insertedUser.setAddress("abcd");
            userDAO.updateUser(insertedUser);
            User updatedUser = userDAO.getLastUser();
            assertEquals(insertedUser.getAddress(), updatedUser.getAddress());
            //Delete
            userDAO.deleteUser(updatedUser.getUserId());
            assertNotEquals(updatedUser.getUserId(), userDAO.getLastUser().getUserId());
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void doGet() {
        try {
            assertNotNull(new RoleDAO().getRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}