package controllers;

import play.mvc.Controller;
import play.mvc.With;


@With(Secure.class)
@Check("administrator")
public class BaseController extends Controller 
{

}
