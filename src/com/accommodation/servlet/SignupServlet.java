package com.accommodation.servlet;

import com.accommodation.dao.RoleDAO;
import com.accommodation.dao.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import static com.accommodation.util.Util.createUserBean;

/**
 * @author chanthan
 */
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        new UserDAO().addUser(createUserBean(request));
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
