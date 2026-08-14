package controller;

import model.GeneroDAO;

import java.util.List;

import model.Genero;

public class GeneroController {
	GeneroDAO dao = new GeneroDAO();
	
	public List<Genero> listarG() {
		return dao.listarTodos();
	}
}
