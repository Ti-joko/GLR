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

import ObjetMetier.*;
import dao.*;

@Path("/film")
public class FilmRessource {

	// PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
	// public FilmDAO filmDao = new FilmDAOImpl(pmf);

	public FilmDAO filmDao = new FilmDAOFake();

	@GET
	@Path("/info/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Film getFilm(@PathParam("name") String name) {
		return filmDao.getFilm(name);
	}

	@PUT
	@Path("/publication/{name}/{date}/{resume}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createFilm(@PathParam("name") String name,
		@PathParam("date") String date,@PathParam("resume") String resume) {
		if(filmDao.createFilm(name, date, resume)) {
			return "ValidCréationFilm :"+name;
		}
		return "EchecCréationFilm";
	}
}
