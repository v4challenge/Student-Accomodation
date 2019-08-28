package com.accommodation.servlet;

import com.accommodation.dao.PropertyDAO;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chanthan
 */
class HomeServletTest {

    @Test
    void doPost() {
        //This method not implemented
    }

    @Test
    void doGet() {
        try {
            assertNotNull(new PropertyDAO().getProperties());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}