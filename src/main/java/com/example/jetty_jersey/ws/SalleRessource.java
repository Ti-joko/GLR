//package com.example.jetty_jersey.ws;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//
//import javax.jdo.JDOHelper;
//import javax.jdo.PersistenceManagerFactory;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import ObjetMetier.*;
//import dao.*;
//
//@Path("/salle")
//public class SalleRessource {
//
//	public SalleDAO SalleDao = new SalleDAOFake();
//
//	// @GET
//	// @Path("/emplacement/{location}")
//	// @Produces(MediaType.APPLICATION_JSON)
//	// public Film getNearestSalles(@PathParam("location") String location) {
//	// 	return salleDao.getNearestSalles(location);
//	// }
//
//	@GET
//	@Path("/aLAffiche/{salle}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Film> getALAffiche(@PathParam("salle") Salle salle) {
//		return SalleDao.getALAffiche(salle);
//	}
//
//	@GET
//	@Path("/planning/{salle}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Map<Film,LocalDateTime> getPlanning(@PathParam("salle") Salle salle, 
//		@PathParam("date") LocalDateTime date) {
//		return SalleDao.getPlanning(salle);
//	}
//
//	@PUT
//	@Path("/ajoutPlanning")
//	public String addFilmPlanning() {
//		return "addFilmPlanning()";
//	}
//}
//
//
