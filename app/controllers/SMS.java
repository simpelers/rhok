package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import play.mvc.After;
import play.mvc.Controller;
import com.google.gson.JsonObject;
import com.voxeo.*;
import com.voxeo.tropo.Tropo;
import com.voxeo.tropo.TropoLaunchResult;

public class SMS extends Controller{

	
	public static void index(String body) throws JsonParseException, JsonMappingException, IOException{
//		String token = "0aec01538a86a147a75a3cd1f45c24ecc71d604ab3c84c2f7ad3951619bb66116862e0cc19f2f48c1067857c";
//		
//		Tropo tropo = new Tropo();
//		Map params = new HashMap();
//	    params.put("number","5148261698");
//	    TropoLaunchResult result = tropo.launchSession(token, params);
//	    System.out.println(result);
//		System.out.println(body.getAsJsonPrimitive("name").getAsString());
		System.out.println(body);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readValue(body, JsonNode.class);
		System.out.println(rootNode.get("name"));
	}
}
