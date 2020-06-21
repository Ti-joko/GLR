package com.example.jetty_jersey.ws;

import java.time.LocalDateTime;

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

import ObjetMetier.Film;
import ObjetMetier.Spectateur;
import dao.*;

@Path("/home")
public class HomeRessource {
	
	// PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
	// public FilmDAO filmDao = new FilmDAOImpl(pmf);

	public FilmDAO filmDao = new FilmDAOFake();

//   @PUT
//   @Produces(MediaType.TEXT_PLAIN)
//   @Consumes(MediaType.TEXT_PLAIN)
//   public String putMessage(@PathParam("id") String name,@PathParam("mdp") String motDePasse) {
//       return "Tentative de Connexion de " + " avec le mdp : " +"avec comme description :";
//   }

    @GET
    @Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Film getExample(@PathParam("name") String name) {
		return filmDao.getFilm(name);
	}

	@PUT
	@Path("/{name}/{date}/{resume}")
	@Produces(MediaType.TEXT_PLAIN)
	public String putFilm(@PathParam("name") String name,
		@PathParam("date") String date,@PathParam("resume") String resume) {
		if(filmDao.createFilm(name, date, resume)) return "ValidCreationFilm";
		return "EchecCréationFilm";
	}

    @GET
    @Path("/truc")
	@Produces(MediaType.APPLICATION_JSON)
	public Spectateur getExample2() {
    	Spectateur user = new Spectateur("nom","mail","mdp");
		return user;
	}

}

