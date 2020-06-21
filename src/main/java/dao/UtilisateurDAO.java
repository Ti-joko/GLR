package dao;

import java.util.List;

import ObjetMetier.Utilisateur;

public interface UtilisateurDAO {

	public List<Utilisateur> getListeAValider();
	public boolean createSpectateur(String name, String mail, String mdp);
	public boolean createGs(String name, String mail, String mdp);
	public boolean createDf(String name, String mail, String mdp);
	public List<Utilisateur> utilisateurAValider();
	public String connexion(String name, String mail, String mdp);
}
