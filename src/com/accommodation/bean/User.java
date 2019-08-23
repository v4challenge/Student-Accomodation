package com.accommodation.bean;

/**
 * @author chanthan
 */
public class User {
    private String email;
    private String password;
    private String first_name;
    /**
     * @return the user_name
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the user_name to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }
    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
