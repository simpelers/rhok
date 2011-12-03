package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Incident extends Model {
	
	public String name;
	public long latitude;
	public long longitude;
	public long timestamp;
	
	public Incident(String name, long latitude, long longitude, long timestamp) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
	}
}
