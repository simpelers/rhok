package controllers;

import models.User;


public class Security extends Secure.Security
{
    static boolean authenticate(String username, String password) 
    {
        User user = Authentication.getUser(username, password);
        return user != null;
    }
    
    static User getConnectedUser()
    {
        //String user user Security.connected()
        return User.find("firstname like ?", connected()).first();
    }

}
