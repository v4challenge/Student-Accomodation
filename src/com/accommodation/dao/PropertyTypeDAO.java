package com.accommodation.dao;

import com.accommodation.bean.PropertyType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chanthan
 */
public class PropertyTypeDAO {
    public List<PropertyType> getPropertyTypes() throws SQLException {
        List<PropertyType> PropertyTypeList = new ArrayList<>();
        ResultSet rs = DBConnector.resultsetExecute("SELECT * FROM property_type");
        while (rs.next()) {
            PropertyTypeList.add(processSummaryRow(rs));
        }
        return PropertyTypeList;
    }

    private static PropertyType processSummaryRow(ResultSet rs) throws SQLException {
        PropertyType propertyType = new PropertyType();
        propertyType.setPropertyId(rs.getInt("property_id"));
        propertyType.setPropertyType(rs.getString("property_type"));
        return propertyType;
    }
}
