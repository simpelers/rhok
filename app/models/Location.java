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
	private String mLat;
    private String mLong;
    
	public Location(String aName, String aLat, String aLong)
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
    public String getLat()
    {
        return mLat;
    }

    /**
     * @param aLat the lat to set
     */
    public void setLat(String aLat)
    {
        mLat = aLat;
    }

    /**
     * @return the long
     */
    public String getLong()
    {
        return mLong;
    }

    /**
     * @param aL the long to set
     */
    public void setLong(String aL)
    {
        mLong = aL;
    }

}
