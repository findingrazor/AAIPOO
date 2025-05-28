package controller;

import javax.swing.JComboBox;

import model.Produto;
import model.ProdutoDAO;

public class ProdutoController {
	ProdutoDAO dao = new ProdutoDAO();
	
	public void salvar(String produto, String midia, String genero, int estoque, float preço) {
		Produto Produto = new Produto(produto, midia, genero, estoque, preço);
		dao.salvar(Produto);
	}

}
