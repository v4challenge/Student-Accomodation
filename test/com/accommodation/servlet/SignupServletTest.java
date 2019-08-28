package com.accommodation.servlet;

import com.accommodation.dao.RoleDAO;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chanthan
 */
class SignupServletTest {

    @Test
    void doPost() {
        //This part already covered in UserServletTest doPost() test method.
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