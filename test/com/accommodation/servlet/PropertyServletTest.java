package com.accommodation.servlet;

import com.accommodation.bean.Property;
import com.accommodation.bean.PropertyType;
import com.accommodation.dao.PropertyDAO;
import com.accommodation.dao.PropertyTypeDAO;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chanthan
 */
class PropertyServletTest {

    @Test
    void doPost() {
        try {
            Property property = new Property();
            PropertyDAO propertyDAO = new PropertyDAO();
            property.setUserId(1);
            property.setAddress("abc");
            property.setPropertyType(String.valueOf(new PropertyTypeDAO().getPropertyTypes().get(0).getPropertyType()));
            property.setTenants(2);
            property.setAmount(2000);
            property.setImage("testImage.png");
            property.setAvailable(true);
            //Insert
            propertyDAO.addProperty(property);
            Property insertedProperty = propertyDAO.getLastProperty();
            assertEquals(property.getUserId(), insertedProperty.getUserId());
            //Update
            insertedProperty.setAddress("abcd");
            propertyDAO.updateProperty(insertedProperty);
            Property updatedProperty = propertyDAO.getLastProperty();
            assertEquals(insertedProperty.getAddress(), updatedProperty.getAddress());
            //Delete
            propertyDAO.deleteProperty(updatedProperty.getPropertyId());
            assertNotEquals(updatedProperty.getPropertyId(), propertyDAO.getLastProperty().getPropertyId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void doGet() {
        try {
            assertNotNull(new PropertyDAO().getLastProperty());
            assertNotNull(new PropertyTypeDAO().getPropertyTypes());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}