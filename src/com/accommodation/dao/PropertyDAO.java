package com.accommodation.dao;

import com.accommodation.bean.Property;
import com.accommodation.bean.User;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.accommodation.util.PasswordMD5.getMD5;

/**
 * @author chanthan
 */
public class PropertyDAO {
    public void addProperty(Property property) throws SQLException {
        String query="INSERT INTO property (user_id, address, property_type, tenants, image, amount, is_available) VALUES('"+
                property.getUserId()+"','"+property.getAddress()+"','"+property.getPropertyType()+"','"+property.getTenants()+"'," +
                "'"+property.getImage()+"','"+property.getAmount()+"',"+property.isAvailable()+")";
        DBConnector.executeQuery(query);
    }


    public List<Property> getProperties() throws SQLException{
        List<Property> propertyList = new ArrayList<>();
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM property");
        while (rs.next()) {
            propertyList.add(processSummaryRow(rs));
        }
        return propertyList;
    }

    public Property getProperty(int propertyId) throws SQLException{
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM property WHERE property_id ='"+propertyId+"'");
        rs.next();
        return processSummaryRow(rs);
    }

    public void updateProperty(Property property) throws SQLException{
        String query="UPDATE property SET user_id='"+property.getUserId()+"',address='"+property.getAddress()+"'," +
                "property_type='"+property.getPropertyType()+"',tenants='"+property.getTenants()+"',image='"+
                property.getImage()+"',amount='"+property.getAmount()+"',is_available="+property.isAvailable()+
                " WHERE property_id='"+property.getPropertyId()+"'";
        DBConnector.executeQuery(query);
    }

    public void bookProperty(int propertyId) throws SQLException{
        String query="UPDATE property SET is_available=false WHERE property_id='"+propertyId+"'";
        DBConnector.executeQuery(query);
    }

    public Property getLastProperty() throws SQLException{
        ResultSet rs =DBConnector.resultsetExecute("SELECT * FROM property ORDER BY property_id DESC LIMIT 1");
        rs.next();
        return processSummaryRow(rs);
    }

    public void deleteProperty(int propertyId) throws SQLException{
        String query="DELETE FROM property WHERE property_id ='"+propertyId+"'";
        DBConnector.executeQuery(query);
    }

    private static Property processSummaryRow(ResultSet rs) throws SQLException {
        Property property= new Property();
        property.setPropertyId(rs.getInt("property_id"));
        property.setUserId(rs.getInt("user_id"));
        property.setAddress(rs.getString("address"));
        property.setPropertyType(rs.getString("property_type"));
        property.setTenants(rs.getInt("tenants"));
        property.setImage(rs.getString("image"));
        property.setAmount(rs.getInt("amount"));
        property.setAvailable(rs.getBoolean("is_available"));
        return property;
    }
}
