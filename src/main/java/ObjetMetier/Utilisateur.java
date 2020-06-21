package ObjetMetier;

public class Utilisateur {

	private String nom;
	private String mail;
	private String mdp;
	
	public Utilisateur(String nom, String mail, String mdp) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
		
}
