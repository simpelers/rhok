package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Location extends Model
{
	private String mName;
    private String mLat;
    private String mLong;
    
    /**
     * @param aLat
     * @param aLong
     */
    public Location(String aName, String aLat, String aLong)
    {
        mLat = aLat;
        mLong = aLong;
    }

    
    public String getmName()
    {
		return mName;
	}


	public void setmName(String mName)
	{
		this.mName = mName;
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
