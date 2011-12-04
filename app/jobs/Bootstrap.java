package jobs;

import models.Incident;
import models.Location;
import models.User;
import play.jobs.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
    	Location l = new Location("Champ de Mars", "123", "1243");
    	l.save();
    	Location l2 = new Location("Cite Soleil","425", "12438");
    	l2.save();
        User user1 = new User("john", "doe", "password", "5144244244", true, l);
        user1.save();
        User user2 = new User("anna", "doe", "password", "5142444433", true, l2);
        user2.save();
        Incident i = new Incident("Gunshot", "description", lastRun, null, lastRun, l, null, user1);
        i.save();
        Incident i2 = new Incident("Gunshot2", "description2", lastRun, null, lastRun, l, null, user1);
        i2.save();
    }
    
}