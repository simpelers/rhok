package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CascadeType;

import play.db.jpa.Model;

@Entity
public class Location extends Model
{
	private String name;
	private double latitude;
    private double longitude;
    
	public Location(String aName, double aLatitude, double aLongitude)
    {
        setName(aName);
        latitude = aLatitude;
        longitude = aLongitude;
    }


    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    /**
     * @return the lat
     */
    public double getLatitude()
    {
        return latitude;
    }

    /**
     * @param aLat the lat to set
     */
    public void setLatitude(double latitude)
    {
        latitude = latitude;
    }

    /**
     * @return the long
     */
    public double getLongitude()
    {
        return longitude;
    }

    /**
     * @param aL the long to set
     */
    public void setLongitude(double longitude)
    {
        longitude = longitude;
    }

}
