package jobs;

import java.util.Calendar;

import models.Incident;
import models.IncidentCategory;
import models.Location;
import models.User;
import play.jobs.*;
import services.Ushahidi;
 
@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
        if (User.count() == 0) {
            Location l = new Location("Champ de Mars", 18.54238, -72.33619);
            l.save();
            Location l2 = new Location("Cite Soleil", 18.58310, -72.33500);
            l2.save();

            IncidentCategory cat1 = new IncidentCategory("Gunshot", 60l*60l*1000l);
            cat1.save();
            IncidentCategory cat2 = new IncidentCategory("Violence", 10l*60l*60l*1000l);
            cat2.save();

            User user0 = new User("a", "z", "a", "5144244244", true, l);
            user0.save();

            User user1 = new User("john", "doe", "password", "5144244244", true, l);
            user1.save();
            User user2 = new User("anna", "doe", "password", "5142444433", true, l2);
            user2.save();

            Calendar calendar = Calendar.getInstance();

            Incident i = new Incident(cat1, "Shoots", "Several shoots were heard.", calendar.getTime(), 75, l, "North", user1);
            i.save();
            Incident i2 = new Incident(cat2, "Tanks burning", "A class has left one tank on fire.", calendar.getTime(), 200, l2, "South", user1);
            i2.save();
        }
    }
    
}