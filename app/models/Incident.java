package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Incident extends Model {
    
    @OneToOne
    public IncidentCategory incidentCategory;
    
    public String incidentTitle;
    public String description;
    public long incidentDate;
    public long duration;
    @OneToOne
    public Location location;
    public String direction;
    
    @OneToOne
    public User User;
    
    
    public Incident(IncidentCategory aIncidentCategory, String incidentTitle, String description,
            long incidentDate, long duration,
            Location location, String direction,
            User user) 
    {
        super();
        this.incidentCategory = aIncidentCategory;
        this.incidentTitle = incidentTitle;
        this.description = description;
        this.incidentDate = incidentDate;
        this.duration = duration;
        this.location = location;
        this.direction = direction;
        User = user;
    }
    
    public String getIncidentDate()
    {
        Date date = new Date(incidentDate);
        return date.toString();
    }
    
    
    @PostPersist
    public void test()
    {
        System.out.println("hihi");
        
        
    }
}