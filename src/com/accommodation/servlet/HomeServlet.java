package com.accommodation.servlet;

import com.accommodation.dao.PropertyDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author chanthan
 */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("properties", new PropertyDAO().getProperties());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
