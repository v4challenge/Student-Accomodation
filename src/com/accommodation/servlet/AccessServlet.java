package com.accommodation.servlet;

import com.accommodation.bean.User;
import com.accommodation.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * @author chanthan
 */
public class AccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new UserDAO().getValidateUser(request.getParameter("email"), request.getParameter("password"));
            HttpSession session = request.getSession();
            session.setAttribute("name", user.getFirstName());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("roleId", user.getRoleId());
            response.sendRedirect("home");
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session !=null) {
            session.invalidate();
        }
        response.sendRedirect("index.jsp");
    }
}
