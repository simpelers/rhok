package services;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.AsyncWebResource.Builder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import models.Incident;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class to interact with Ushahidi.
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
public class Ushahidi
{
    private static Logger LOGGER = LoggerFactory.getLogger(Ushahidi.class);

    private String url;
    private String username;
    private String password;

    public Ushahidi(String url, String username, String password)
    {

        this.url = url;
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void storeIncident(Incident report)
    {
        try
        {
            Client client = Client.create();
            //client.addFilter(new HTTPBasicAuthFilter(username, password));
            AsyncWebResource resource = client.asyncResource(url);

            StringBuilder contentBuilder = new StringBuilder();
            contentBuilder.append("task=report");
            addParameter(contentBuilder, "incident_title", report.incidentTitle);
            addParameter(contentBuilder, "incident_description", report.description);
            addParameter(contentBuilder, "incident_category", report.incidentCategory.getName());
            addParameter(contentBuilder, "incident_date", report.getIncidentDateForUshahidi());
            addParameter(contentBuilder, "incident_hour", DateFormatUtils.format(report.incidentDate, "hh"));
            addParameter(contentBuilder, "incident_minute", DateFormatUtils.format(report.incidentDate, "mm"));
            addParameter(contentBuilder, "incident_ampm", DateFormatUtils.format(report.incidentDate, "a").toLowerCase());
            addParameter(contentBuilder, "latitude", String.valueOf(report.location.getLatitude()));
            addParameter(contentBuilder, "longitude", String.valueOf(report.location.getLongitude()));
            addParameter(contentBuilder, "location_name", report.location.getName());
            addParameter(contentBuilder, "person_first", report.User.getFirstName());
            addParameter(contentBuilder, "person_last", report.User.getLastName());
            //addParameter(contentBuilder, "person_email", );
            addParameter(contentBuilder, "resp", "json");

            String content = formEncode(contentBuilder.toString());

            LOGGER.info("Sending: " + content);

            Builder builder = resource.type("application/x-www-form-urlencoded");
            Future<String> future = builder.post(String.class, content);
            String response = future.get();
            LOGGER.info(response);
        }
        catch (Exception e)
        {
            String errorMessage = generateErrorMessage();
            throw new RuntimeException(errorMessage, e);
        }
    }

    public String getGoogleMapsApiKey()
    {
        try
        {
            Client client = Client.create();
            //client.addFilter(new HTTPBasicAuthFilter(username, password));

            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append(url);
            urlBuilder.append("?task=apikeys");
            addParameter(urlBuilder, "by", "google");
            addParameter(urlBuilder, "resp", "json");

            WebResource resource = client.resource(urlBuilder.toString());
            LOGGER.debug("Getting api key with url: " + urlBuilder.toString());

            String response = resource.get(String.class);

            ObjectMapper mapper = new ObjectMapper();
            LOGGER.info("Received response: " + response);
            Response jsonResponse = mapper.readValue(response, Response.class);
            return jsonResponse.payload.services.get(0).service.apikey;
        }
        catch (Exception e)
        {
            String errorMessage = generateErrorMessage();
            throw new RuntimeException(errorMessage, e);
        }
    }

    private String formEncode(String aData)
    {
        // Replace any white spaces with the '+' character
        String data = StringUtils.replace(aData, " ", "+");

        // Remove white spaces
        return data.trim();
    }

    private void addParameter(StringBuilder aContentBuilder, String name, String value)
    {
        aContentBuilder.append("&");
        aContentBuilder.append(name);
        aContentBuilder.append("=");
        aContentBuilder.append(value);
    }

    private String generateErrorMessage()
    {
        return String.format("Error sending request to %1$s", url);
    }

    private static class Response
    {
        public Payload payload;
        public Error error;

    }

    private static class Payload
    {
        public String domain;
        public List<Service> services;

    }

    private static class Service
    {
        public ServiceData service;

    }

    private static class ServiceData
    {
        public String id;
        public String apikey;
    }

    private static class Error
    {
        public String code;
        public String message;
    }
}
