package controller;

import java.util.List;

import model.FormaPagDAO;
import model.FormaPag;


public class FormaPagController {
	FormaPagDAO dao = new FormaPagDAO();
	
	public List<FormaPag> listar(){
		return dao.listarTodos();
	}
}
