package com.example.jetty_jersey.ws;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ObjetMetier.*;
import dao.*;

@Path("/utilisateur")
public class UtilisateurRessource {

	public UtilisateurDAO utilisateurDao = new UtilisateurDAOFake();

	@PUT
	@Path("/spectateur/{nom}/{mail}/{mdp}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createSpectateur(@PathParam("nom") String name,
		@PathParam("mail") String mail,@PathParam("mdp") String mdp) {
		if(utilisateurDao.createSpectateur(name, mail, mdp)) {
			return "ValidNewSpectateur : "+name+" "+mail+" ";
		}
		return "ErrorNewSpectateur";
	}

	@PUT
	@Path("/gs/{nom}/{mail}/{mdp}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createGs(@PathParam("nom") String name,
		@PathParam("mail") String mail,@PathParam("mdp") String mdp) {
		if(utilisateurDao.createGs(name, mail, mdp)) {
			return "NewGsAValider";
		}
		return "ErrorNewGs";
	}
	
	@PUT
	@Path("/df/{nom}/{mail}/{mdp}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createDf(@PathParam("nom") String name,
		@PathParam("mail") String mail,@PathParam("mdp") String mdp) {
		if(utilisateurDao.createDf(name, mail, mdp)) {
			return "NewDfAValider";
		}
		return "ErrorNewDf";
	}
	@GET
	@Path("/inscription")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> utilisateurAValider() {
		return utilisateurDao.getListeAValider();
	}

	
 	

}
