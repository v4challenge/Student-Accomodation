package com.accommodation.dao;

import com.accommodation.bean.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chanthan
 */
public class RoleDAO {
    public List<Role> getRole() throws SQLException {
        List<Role> list = new ArrayList<Role>();
        ResultSet rs = DBConnector.resultsetExecute("SELECT * FROM role");
        while (rs.next()) {
            list.add(processSummaryRow(rs));
        }
        return list;
    }

    private static Role processSummaryRow(ResultSet rs) throws SQLException {
        Role role= new Role();
        role.setRoleId(rs.getInt("role_id"));
        role.setRoleName(rs.getString("role_name"));
        return role;
    }
}
