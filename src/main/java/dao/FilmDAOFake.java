package dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ObjetMetier.Film;

public class FilmDAOFake implements FilmDAO {

	private static List<Film> listeFilms = new ArrayList<Film>();
	
	public List<Film> getFilms() {
		return listeFilms;
	}
	public Film getFilm(String nom) {
		for(Film f : listeFilms) {
			if(nom.equals(f.getNom())) {
				return f;
			}
		}		
		System.out.println(listeFilms.size());
		return null;
	}

	public boolean createFilm(String nom, String date, String resume) {
		for(Film f : listeFilms) {
			if(nom.equals(f.getNom())) {
				return false;
			}
		}
		Film film = new Film(nom, date, resume);
		System.out.println(listeFilms.add(film));
		System.out.println(listeFilms.size());
		return true;
	}
}
