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

/**
 * @author chanthan
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(getMD5(request.getParameter("password")));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAddress(request.getParameter("address"));
        user.setTelephoneNumber(request.getParameter("telephoneNumber"));
        user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
        user.setStudentId(request.getParameter("studentId"));
        user.setInRent(false);
        user.setActive(true);
        new UserDAO().addUser(user);
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("roles", new RoleDAO().getRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }
}
