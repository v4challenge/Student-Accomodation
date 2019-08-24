package com.accommodation.util;

import com.accommodation.bean.User;

import javax.servlet.http.HttpServletRequest;

import java.security.NoSuchAlgorithmException;

import static com.accommodation.util.PasswordMD5.getMD5;

/**
 * @author chanthan
 */
public class Util {
    public static User createUserBean(HttpServletRequest request) throws NoSuchAlgorithmException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(getMD5(request.getParameter("password")));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAddress(request.getParameter("address"));
        user.setTelephoneNumber(request.getParameter("telephoneNumber"));
        user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
        user.setStudentId(request.getParameter("studentId")!=null?request.getParameter("studentId"):"0");
        user.setRentId(0);
        user.setActive(true);
        return user;
    }
}
