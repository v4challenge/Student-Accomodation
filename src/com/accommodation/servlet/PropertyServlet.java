package com.accommodation.servlet;

import com.accommodation.bean.Property;
import com.accommodation.dao.PropertyDAO;
import com.accommodation.dao.PropertyTypeDAO;

import javax.servlet.ServletException;
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
public class PropertyServlet extends HttpServlet {
    private String action = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Property property = new Property();
            property.setUserId((Integer) session.getAttribute("userId"));
            property.setAddress(request.getParameter("address"));
            property.setPropertyType(request.getParameter("propertyType"));
            property.setTenants(Integer.parseInt(request.getParameter("tenants")));
            property.setAmount(Integer.parseInt(request.getParameter("amount")));
            property.setImage(request.getParameter("image"));
            property.setAvailable(true);
            if (action.equals("edit")) {
                property.setPropertyId(Integer.parseInt(request.getParameter("propertyId")));
                new PropertyDAO().updateProperty(property);
            } else if (action.equals("delete")) {
                new PropertyDAO().deleteProperty(Integer.parseInt(request.getParameter("propertyId")));
            } else {
                new PropertyDAO().addProperty(property);
            }
            request.setAttribute("properties", new PropertyDAO().getProperties());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        try {
            if (edit != null) {
                action = "edit";
                request.setAttribute("property", new PropertyDAO().getProperty(Integer.parseInt(edit)));
                request.setAttribute("action", action);
            }
            if (delete != null) {
                action = "delete";
                request.setAttribute("property", new PropertyDAO().getProperty(Integer.parseInt(delete)));
                request.setAttribute("action", action);
            }
            request.setAttribute("propertyTypes", new PropertyTypeDAO().getPropertyTypes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("property.jsp").forward(request, response);
    }
}
