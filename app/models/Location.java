/**
 * 
 */
package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Location extends Model
{
    public String mLat;
    public String mLong;
    
    /**
     * @param aLat
     * @param aL
     */
    public Location(String aLat, String aL)
    {
        mLat = aLat;
        mLong = aL;
    }



}
