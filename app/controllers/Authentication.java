/**
 * 
 */
package controllers;

import models.User;

/**
 * This class is used to 
 * TODO AndrewS Dec 3, 2011 MISSING_CLASS_HEADER_JAVADOC
 *
 * <p>
 * The information contained herein is the property of Nokia and is strictly proprietary and 
 * confidential. Except as expressly authorized in writing by Nokia, you do not have the right
 * to use the information contained herein and you shall not disclose it to any third party.</p>
 *
 * <br>Copyright 2011 Nokia. All Rights Reserved.<br>
 *
 * @author AndrewS
 * @since Dec 3, 2011
 */
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
