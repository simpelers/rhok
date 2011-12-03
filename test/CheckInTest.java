import models.Location;
import models.User;

import org.junit.Test;

import play.test.UnitTest;

import controllers.CheckIn;


public class CheckInTest extends UnitTest
{
    
    @Test
    public void aCheckInTest()
    {
        //Set up
        Location startLocation = new Location("11", "22");
        startLocation.save();
        (new User("firstName", "lastName", "password", "0000", false, startLocation)).save();
        
        //Test
        CheckIn.checkin("0000", new Location("33", "33"));
        
        
        //Verify
        User user = User.find("phonenumber", "0000").first();
        Location location = user.getLocation();
        assertTrue(location.getLat().equals("33"));
        assertTrue(location.getLong().equals("33"));
        
    }

}
