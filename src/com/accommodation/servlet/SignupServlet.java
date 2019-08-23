package com.accommodation.servlet;

import com.accommodation.DAO.UserDAO;
import com.accommodation.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author chanthan
 */
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String roleIdUser = getServletContext().getInitParameter("roleIdUser");
        //HttpSession session = request.getSession();
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setFirst_name(request.getParameter("first_name"));
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
