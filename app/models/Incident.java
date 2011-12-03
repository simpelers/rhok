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
	public String location;
	public String direction;
	public long latitude;
	public long longitude;
	public String User;
	public Incident(String incidentTitle, String description,
			long incidentDate, String incidentType, long duration,
			String location, String direction, long latitude, long longitude,
			String user) {
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
