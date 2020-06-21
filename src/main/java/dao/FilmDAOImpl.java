package dao;


import java.time.LocalDateTime;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import ObjetMetier.Film;

public class FilmDAOImpl implements FilmDAO{

	private PersistenceManagerFactory pmf;
	
	public FilmDAOImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}	

	public Film getFilm(String nomFilm) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Film f = null;
		Film detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Film.class);
			q.declareParameters("String nomFilm");
			q.setFilter("nomFilm == nom");
			q.setUnique(true);
			
			f = (Film) q.execute(nomFilm);
			detached = (Film) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@SuppressWarnings("finally")
	public boolean createFilm(String nom, String date, String resume) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Film film = new Film(nom, date, resume);
			pm.makePersistent(film);
			tx.commit();
		} 
		finally {
			if (tx.isActive()) {
				tx.rollback();
				return false;
			}
			pm.close();
			return true;
		}
	}
}
