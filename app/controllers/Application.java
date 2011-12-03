package controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import models.Incident;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
    	try {
    		List<Incident> all = Incident.findAll();
    		
			render(all);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}