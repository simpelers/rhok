package services;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import models.Incident;
import models.IncidentCategory;
import models.Location;
import models.User;
import org.junit.Test;

/**
 * Test class for the Ushahidi service
 *
 * <p>
 * The information contained herein is the property of OZ Communications Inc. and is strictly proprietary and
 * confidential. Except as expressly authorized in writing by OZ Communications Inc., you do not have the right
 * to use the information contained herein and you shall not disclose it to any third party.</p>
 *
 * <br>Copyright 2011 Nokia Inc. All Rights Reserved.<br>
 *
 * @author Alexandre Normand (AlexandreN)
 * @since 12/3/11
 */
public class UshahidiTest
{
    @Test
    public void testStoreIncident() throws Exception
    {
 
        Calendar calendar = Calendar.getInstance();

    	Ushahidi ushahidi = new Ushahidi("https://simpelers.crowdmap.com/api", "andrew@tillnow.com", "qazwsx");
        ushahidi.storeIncident(
            new Incident(new IncidentCategory("Fire", 60), "testtitle", "description", calendar.getTime(),
                45L, new Location("FarAway", 45.00, 49.00), "North",
                new User("test", "api", "pass", "514", true, null)));
    }

}
