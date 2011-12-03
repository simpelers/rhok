package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Incident extends Model {
	
	public String incidentTitle;
	public String description;
	public long incidentDate;
	public IncidentCategory incidentCategory; ///ENUM
	public long duration;
	public Location location;
	public String direction;
	public long latitude;
	public long longitude;
	public User User;
	
	
	public Incident(String incidentTitle, String description,
			long incidentDate, IncidentCategory incidentCategory, long duration,
			Location location, String direction, long latitude, long longitude,
			User user) 
	{
		super();
		this.incidentTitle = incidentTitle;
		this.description = description;
		this.incidentDate = incidentDate;
		this.incidentCategory = incidentCategory;
		this.duration = duration;
		this.location = location;
		this.direction = direction;
		this.latitude = latitude;
		this.longitude = longitude;
		User = user;
	}

	public String getIncidentTitle() {
		return incidentTitle;
	}


	public void setIncidentTitle(String incidentTitle) {
		this.incidentTitle = incidentTitle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public long getIncidentDate() {
		return incidentDate;
	}


	public void setIncidentDate(long incidentDate) {
		this.incidentDate = incidentDate;
	}

	@ManyToOne
	public IncidentCategory getIncidentCategory() {
		return incidentCategory;
	}


	public void setIncidentCategory(IncidentCategory incidentCategory) {
		this.incidentCategory = incidentCategory;
	}


	public long getDuration() {
		return duration;
	}


	public void setDuration(long duration) {
		this.duration = duration;
	}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="location_fk")
	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public long getLatitude() {
		return latitude;
	}


	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}


	public long getLongitude() {
		return longitude;
	}


	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_fk")
	public User getUser() {
		return User;
	}


	public void setUser(User user) {
		User = user;
	}
	
}
