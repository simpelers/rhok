package controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.List;

import org.junit.experimental.categories.Categories.IncludeCategory;

import controllers.CRUD.ObjectType;

import models.Incident;
import models.IncidentCategory;
import models.Location;
import models.User;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import play.mvc.Controller;
import play.mvc.With;
import services.Ushahidi;

public class Application extends BaseController 
{
    public static final Ushahidi USHAHIDI = new Ushahidi("https://simpelers.crowdmap.com/api", "andrew@tillnow.com", "qazwsx");
    
    public static void main()
    {
        User loggedInUser = Security.getConnectedUser();

        try {
            List<Incident> all = Incident.find("order by incidentDate desc").fetch();
            
            if (loggedInUser != null)
            {
                render(loggedInUser, all);                
            }
            else
            {
                render(loggedInUser, all);  
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void mapview()
    {
        User loggedInUser = Security.getConnectedUser();
        
    	try {
    		List<Incident> all = Incident.find("order by incidentDate desc").fetch();
            String mapsApiKey = "AIzaSyCnQ1Mxs0qi9g26mYEF_OgxNvnY-eGm5Uw";//USHAHIDI.getGoogleMapsApiKey();

            if (loggedInUser != null)
            {
                render(loggedInUser, mapsApiKey, all);
            }
            else
            {
                render(mapsApiKey, loggedInUser, all);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void newReport() throws Exception
    {
        User loggedInUser = Security.getConnectedUser();
        
        Incident incident = new Incident();
        List<IncidentCategory> categories = IncidentCategory.findAll();
        List<Location> locations = Location.findAll();
        try 
        {
            if (loggedInUser != null)
            {
                render(loggedInUser, incident, categories, locations);                
            }
            else
            {
                render(incident, categories, locations);  
            }
            
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveReport(Long categoryId, String title, Long locationId, String content, String duration,  String direction) throws Exception
    {
        IncidentCategory cat = (IncidentCategory) IncidentCategory.findById(categoryId);
        Incident i = new Incident(cat,
                title,
                content,
                Calendar.getInstance().getTime(),
                getEstDuration(cat, duration),
                (Location) Location.findById(locationId),
                direction,
                (User) User.find("byFirstName", "john").first()); //HARDCODED!!
        
        // Validate
        validation.valid(i);
        if(validation.hasErrors()) {
            render("@form", i);
        }
        // Save
        i.save();
        main();
    }
    
    private static long getEstDuration(IncidentCategory cat, String estDuration)
    {
        if(estDuration == null || estDuration.isEmpty()){
            return cat.getDefaultDurationMins();
        }
        return Long.parseLong(estDuration);
    }
}