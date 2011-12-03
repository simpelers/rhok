/**
 * 
 */
package controllers;

import models.Location;
import models.User;


public class CheckIn
{
    
    public static boolean checkin(String aPhoneNumber, Location aLocation)
    {
        User user = User.find("byNumber", "514").first();
        
        if (user == null)
        {
            return false;
        }
        
        //User
        
        
        return true;
    }

}
