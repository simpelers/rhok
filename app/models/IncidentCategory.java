package models;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;


import play.db.jpa.Model;


@Entity
public class IncidentCategory extends Model {
 
//	private List<Incident> incidents;
	public String name;
	public long duration;
	
	
	public IncidentCategory(String name, long duration) {
		super();
		this.name = name;
		this.duration = duration;
	}
/*
    @OneToMany(mappedBy="incidents", cascade = CascadeType.ALL)
	public List<Incident> getIncidents() {
		return incidents;
	}

	public void setIncident(List<Incident> incidents) {
		this.incidents = incidents;
	}
*/
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
