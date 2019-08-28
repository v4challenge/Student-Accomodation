package com.accommodation.servlet;

import com.accommodation.dao.PropertyDAO;
import com.accommodation.dao.UserDAO;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.sql.SQLException;

import static com.accommodation.util.Util.sendEmail;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chanthan
 */
class BookServletTest {

    @Test
    void doPost() {
        //This method not implemented
    }

    @Test
    void doGet() {
        int propertyId = 18;
        UserDAO userDAO = new UserDAO();
        try {
            int ownerId = 1;
            int userId = 2;
            userDAO.updateRentId(propertyId, userId);
            String email = "test@gmail.com";
            PropertyDAO propertyDAO = new PropertyDAO();
            propertyDAO.bookProperty(propertyId);
            String message = "New request for your property from this email:" + email;
            //sendEmail(userDAO.getUser(ownerId).getEmail(), "New Request for your Property", message);
            assertFalse(propertyDAO.getProperty(propertyId).isAvailable());
            assertEquals(userDAO.getUser(userId).getRentId(), propertyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}