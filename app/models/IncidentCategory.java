package models;

import java.util.*;

import javax.persistence.Entity;


@Entity
public class IncidentCategory {
 
	public String name;
	public long duration;
	
	public IncidentCategory(String name, long duration) {
		super();
		this.name = name;
		this.duration = duration;
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
