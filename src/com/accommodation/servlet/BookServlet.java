package com.accommodation.servlet;

import com.accommodation.dao.PropertyDAO;
import com.accommodation.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author chanthan
 */
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int propertyId = Integer.parseInt(request.getParameter("propertyId"));
            new UserDAO().updateRentId(propertyId, (Integer) request.getSession().getAttribute("userId"));
            new PropertyDAO().bookProperty(propertyId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //change it to profile view with house
        response.sendRedirect("home");
    }
}
