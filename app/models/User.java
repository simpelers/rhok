package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class User extends Model {
 
	private Incident incident;
    private String firstName;
    private String lastName;
    private String password;
    private String phonenumber;
    private boolean isAdmin;
    
    @ManyToOne
    private Location mLocation;
    
    public User(String firstName, String lastName, String password,
			String phonenumber, boolean isAdmin, Location mLocation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phonenumber = phonenumber;
		this.isAdmin = isAdmin;
		this.mLocation = mLocation;
	}


    @OneToOne(mappedBy = "user")
	public Incident getIncident() {
		return incident;
	}



	public void setIncident(Incident incident) {
		this.incident = incident;
	}



	/**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param aFirstName the firstName to set
     */
    public void setFirstName(String aFirstName)
    {
        firstName = aFirstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param aLastName the lastName to set
     */
    public void setLastName(String aLastName)
    {
        lastName = aLastName;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public void setPassword(String aPassword)
    {
        password = aPassword;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber()
    {
        return phonenumber;
    }

    /**
     * @param aPhonenumber the phonenumber to set
     */
    public void setPhonenumber(String aPhonenumber)
    {
        phonenumber = aPhonenumber;
    }

    /**
     * @return the isAdmin
     */
    public boolean isAdmin()
    {
        return isAdmin;
    }

    /**
     * @param aIsAdmin the isAdmin to set
     */
    public void setAdmin(boolean aIsAdmin)
    {
        isAdmin = aIsAdmin;
    }

    /**
     * @return the location
     */
    public Location getLocation()
    {
        return mLocation;
    }

    /**
     * @param aLocation the location to set
     */
    public void setLocation(Location aLocation)
    {
        mLocation = aLocation;
    }
    
    
    
    
    
 
}