package controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
    	try {
//			URLConnection c = new URL("http://www.rhok.org").openConnection();
//			InputStream is = c.getInputStream();
//			InputStreamReader reader = new InputStreamReader(is);
//			BufferedReader breader = new BufferedReader(reader);
//			String line = breader.readLine();
//			is.close();
			render();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

}