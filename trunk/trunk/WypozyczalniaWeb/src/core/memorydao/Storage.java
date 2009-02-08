package core.memorydao;

import java.util.HashMap;

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.PlytaDAO;

public class Storage {
	public static HashMap<String, PlytaDAO> plytyBufor = new HashMap<String, PlytaDAO>();
	public static HashMap<Integer, FilmDAO> filmyBufor = new HashMap<Integer, FilmDAO>();

}
