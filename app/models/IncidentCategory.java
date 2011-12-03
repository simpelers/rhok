package models;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.db.jpa.Model;


@Entity
public class IncidentCategory extends Model {
 
	private Map<String, Incident> incidents;
	public String name;
	public long duration;
	
	
	public IncidentCategory(String name, long duration) {
		super();
		this.name = name;
		this.duration = duration;
	}

    @OneToMany(mappedBy="software")
    @MapKey(name="id")
	public Map<String, Incident> getIncidents() {
		return incidents;
	}

	public void setIncident(Map<String, Incident> incidents) {
		this.incidents = incidents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

}
