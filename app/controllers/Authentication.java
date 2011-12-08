package controllers;

import models.User;

public class Authentication
{

    public static User getUser(String aFirstName, String aPassword)
    {
        return User.find("firstname like ? and password like ?", aFirstName, aPassword).first();
    }
    
    
    public static User getUser(String aFirstName, String aLastName, String aPassword)
    {
        return User.find("firstname like ? and lastname like ? and password like ?", aFirstName, aLastName, aPassword).first();
    }
    
    public static User getUser(String aPhoneNumber)
    {
        return User.find("phonenumber", aPhoneNumber).first();
    }

}
