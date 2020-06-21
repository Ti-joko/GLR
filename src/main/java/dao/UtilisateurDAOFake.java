package dao;
import java.util.ArrayList;
import java.util.List;

import ObjetMetier.*;
import ObjetMetier.*;
public class UtilisateurDAOFake implements UtilisateurDAO {

	private static List<Utilisateur> listeSpectateur = new ArrayList<Utilisateur>();
	private static List<Utilisateur> listeAValider = new ArrayList<Utilisateur>();
	private static List<Utilisateur> listeDf = new ArrayList<Utilisateur>();
	private static List<Utilisateur> listeGs = new ArrayList<Utilisateur>();
	private static Utilisateur as = new As("as","as@as.as","as");

	public List<Utilisateur> getListeAValider() {
		return listeAValider;
	}

	public boolean exists(String nom, String mail, String mdp) {
		for(Utilisateur u : listeSpectateur) {
			if(mail.equals(u.getMail())) {
				return true;
			}
		}
		for(Utilisateur u : listeDf) {
			if(mail.equals(u.getMail())) {
				return true;
			}
		}
		for(Utilisateur u : listeGs) {
			if(mail.equals(u.getMail())) {
				return true;
			}
		}	
		for(Utilisateur u : listeAValider) {
			if(mail.equals(u.getMail())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean createSpectateur(String nom, String mail, String mdp) {
		if(!exists(nom,mail,mdp)) {
			Utilisateur util = new Spectateur(nom, mail, mdp);
			listeSpectateur.add(util);
			return true;
		}
		return false;
	}

	public boolean createGs(String nom, String mail, String mdp) {
		if(!exists(nom,mail,mdp)) {
			Gs util = new Gs(nom, mail, mdp);
			listeAValider.add(util);
			return true;
		}
		return false;
	}

	public boolean createDf(String nom, String mail, String mdp) {
		if(!exists(nom,mail,mdp)) {
			Df util = new Df(nom, mail, mdp);
			listeAValider.add(util);
			System.out.println(listeAValider.size());
			return true;
		}
		return false;
	}

	public Utilisateur connexion2(String nom, String mail, String mdp) {
		if(as.getNom().equals(nom) &&
			as.getMail().equals(mail) &&
			as.getMdp().equals(mdp)) {
			return as;
	}
	if(exists(nom, mail, mdp)) {
		for(Utilisateur u : listeSpectateur) {
			if(u.getNom().equals(nom) &&
				u.getMail().equals(mail) &&
				u.getMdp().equals(mdp))
				return u;
		}
		for(Utilisateur u : listeGs) {
			if(u.getNom().equals(nom) &&
				u.getMail().equals(mail) &&
				u.getMdp().equals(mdp))
				return u;			}
			for(Utilisateur u : listeDf) {
				if(u.getNom().equals(nom) &&
					u.getMail().equals(mail) &&
					u.getMdp().equals(mdp))
					return u;	
			}
		}
		return null;
	}

	public String connexion(String nom, String mail, String mdp) {
		Utilisateur u = connexion2(nom, mail, mdp);
		if(u == null) return "ErrorConnexion";
		if(u instanceof As) return "as.html";
		if(u instanceof Gs) return "gs.html?mail="+u.getMail();
		if(u instanceof Df) return "df.html?mail="+u.getMail();
		return "spectateur.html?mail="+u.getMail();
	}


	public List<Utilisateur> utilisateurAValider() {
		//A  FAIRE
		return null;
	}

}
