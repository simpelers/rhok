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
	private double mLat;
    private double mLong;
    
	public Location(String aName, double aLat, double aLong)
    {
        setName(aName);
        mLat = aLat;
        mLong = aLong;
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
    public double getLat()
    {
        return mLat;
    }

    /**
     * @param aLat the lat to set
     */
    public void setLat(double aLat)
    {
        mLat = aLat;
    }

    /**
     * @return the long
     */
    public double getLong()
    {
        return mLong;
    }

    /**
     * @param aL the long to set
     */
    public void setLong(double aL)
    {
        mLong = aL;
    }

}
