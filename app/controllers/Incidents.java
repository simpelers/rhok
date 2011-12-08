package controllers;

import models.Incident;

import play.mvc.With;

@With(Secure.class)
@Check("administrator")
public class Incidents extends CRUD 
{


}