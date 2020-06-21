package ObjetMetier;

import java.time.LocalDateTime;

import javax.jdo.annotations.PersistenceCapable;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;

@PersistenceCapable(detachable="true")
public class Salle {

	private String nom;
	private String localisation;
	private List<Film> films;
	private Map<Film,LocalDateTime> planning;
	
	
	public Salle(String nom, String localisation) {
		super();
		this.nom = nom;
		this.localisation = localisation;
	}

	public Map<Film, LocalDateTime> getPlanning() {
		return planning;
	}

	public void setPlanning(Map<Film, LocalDateTime> planning) {
		this.planning = planning;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}



}
