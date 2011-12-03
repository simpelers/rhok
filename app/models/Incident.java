package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Incident extends Model {
	
	public String incidentTitle;
	public String description;
	public long incidentDate;
	public String incidentType; ///ENUM
	public long duration;
	@OneToOne
	public Location location;
	public String direction;
	public long latitude;
	public long longitude;
	
	@OneToOne
	public User User;
	
	
	public Incident(String incidentTitle, String description,
			long incidentDate, String incidentType, long duration,
			Location location, String direction, long latitude, long longitude,
			User user) 
	{
		super();
		this.incidentTitle = incidentTitle;
		this.description = description;
		this.incidentDate = incidentDate;
		this.incidentType = incidentType;
		this.duration = duration;
		this.location = location;
		this.direction = direction;
		this.latitude = latitude;
		this.longitude = longitude;
		User = user;
	}
	
	
}
