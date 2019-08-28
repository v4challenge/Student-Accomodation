package com.accommodation.servlet;

import com.accommodation.dao.PropertyDAO;
import com.accommodation.dao.UserDAO;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import static com.accommodation.util.Util.sendEmail;
/**
 * @author chanthan
 */
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int propertyId = Integer.parseInt(request.getParameter("propertyId"));
            int ownerId = Integer.parseInt(request.getParameter("userId"));
            UserDAO userDAO = new UserDAO();
            userDAO.updateRentId(propertyId, (Integer) request.getSession().getAttribute("userId"));
            new PropertyDAO().bookProperty(propertyId);
            String message = "New request for your property from this email:" + request.getSession().getAttribute("email");
            sendEmail(userDAO.getUser(ownerId).getEmail(), "New Request for your Property", message);
        } catch (SQLException | MessagingException e) {
            e.printStackTrace();
        }
        response.sendRedirect("home");
    }
}
