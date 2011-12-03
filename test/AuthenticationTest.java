import models.Location;
import models.User;

import org.junit.Test;

import controllers.Authentication;
import controllers.CheckIn;
import play.test.UnitTest;


public class AuthenticationTest extends UnitTest
{
    
    @Test
    public void getUserFullTest()
    {
        //Set up
        Location startLocation = new Location("11", "22");
        startLocation.save();
        (new User("firstName", "lastName", "password", "0000", false, startLocation)).save();
        (new User("firstName2", "lastName2", "password", "0000", false, startLocation)).save();
        
        
        //Test
        User user = Authentication.getUser("firstName", "lastName", "password");
        
        
        //Verify
        assertTrue(user.getFirstName().equals("firstName"));
        assertTrue(user.getLastName().equals("lastName"));
        
    }
    
    @Test
    public void getUserPhoneNumberTest()
    {
        //Set up
        Location startLocation = new Location("11", "22");
        startLocation.save();
        (new User("firstName", "lastName", "password", "0000", false, startLocation)).save();
        (new User("firstName2", "lastName2", "password", "1000", false, startLocation)).save();
        
        
        //Test
        User user = Authentication.getUser("0000");
        
        
        //Verify
        assertTrue(user.getFirstName().equals("firstName"));
        assertTrue(user.getLastName().equals("lastName"));
        assertTrue(user.getPhonenumber().equals("0000"));
        
    }   

}
