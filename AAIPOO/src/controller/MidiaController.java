package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Midia;
import model.MidiaDAO;

public class MidiaController {
	MidiaDAO dao = new MidiaDAO();
	
	public List<Midia> listar() {
		return dao.listarTodos();
	}
	
	public int pegarCodMidia(ArrayList<String> lista) {
		int codMidia;
		for (int index =  0; index == 2; index++) {
			if (lista.get(index).equals("CD")) {
				return codMidia = 1;
			} else if (lista.get(index).equals("DVD")) {
				return codMidia = 2;
			} else if (lista.get(index).equals("LP")) {
				return codMidia = 3;
			} else {
				JOptionPane.showMessageDialog(null, "Midia invalida");
			}	
		}  
		return 0;
	}

}
