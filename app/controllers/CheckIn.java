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
        User user = User.find("phonenumber", aPhoneNumber).first();
        
        if (user == null)
        {
            return false;
        }
        
        user.setLocation(aLocation);
        
        return true;
    }

}
