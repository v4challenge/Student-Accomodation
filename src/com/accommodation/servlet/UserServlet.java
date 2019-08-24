package com.accommodation.servlet;

import com.accommodation.bean.User;
import com.accommodation.dao.RoleDAO;
import com.accommodation.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static com.accommodation.util.PasswordMD5.getMD5;
import static com.accommodation.util.Util.createUserBean;

/**
 * @author chanthan
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        User user = createUserBean(request);
        user.setUserId((Integer) request.getSession().getAttribute("userId"));
        user.setPassword(request.getParameter("password"));
        user.setRentId(Integer.parseInt(request.getParameter("rentId")));
        new UserDAO().updateUser(user);
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        response.sendRedirect("user");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("roles", new RoleDAO().getRole());
            request.setAttribute("user", new UserDAO().getUser((Integer) request.getSession().getAttribute("userId")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}
