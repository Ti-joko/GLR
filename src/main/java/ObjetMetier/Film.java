package ObjetMetier;

import java.time.LocalDateTime;

import javax.jdo.annotations.PersistenceCapable;

import org.codehaus.jackson.annotate.JsonProperty;

@PersistenceCapable(detachable="true")
public class Film {

	private String nom;
	private String dateDeSortie;
	private String résumé;


	public Film(@JsonProperty("nom") String nom,String date, String résumé) {
		super();
		this.nom = nom;
		this.dateDeSortie = date;
		this.résumé = résumé;
	}

	public Film(@JsonProperty("nom") String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(String dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public String getRésumé() {
		return résumé;
	}

	public void setRésumé(String résumé) {
		this.résumé = résumé;
	}
	
}
