package dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import ObjetMetier.Film;
import ObjetMetier.Salle;

public interface SalleDAO {

	//public Salle getNearestSallle(String location);
	public List<Film> getALAffiche(Salle salle);
	public Map<Film,LocalDateTime> getPlanning(Salle salle);
}