package com.accommodation.servlet;

import com.accommodation.bean.User;
import com.accommodation.dao.UserDAO;
import org.junit.jupiter.api.Test;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author chanthan
 */
class AccessServletTest {

    @Test
    void doPost() {
        try {
            User user = new UserDAO().getValidateUser("stu@gmail.com ", "1");
            assertNotNull(user);
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    void doGet() {
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getSession()).thenReturn(session);
        session.setAttribute("name",null);
        assertNull(session.getAttribute("name"));
    }
}