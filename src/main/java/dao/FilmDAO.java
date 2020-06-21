package dao;

import java.time.LocalDateTime;

import ObjetMetier.Film;

public interface FilmDAO {
	public Film getFilm(String nom);
	public boolean createFilm(String nom, String date, String resume);

}
