package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.MidiaController;

public class Produto {
	
	private String produto;
	private String Midia;
	private String genero;
	private int estoque;
	private float preço;

	public Produto(String produto, String midia, String genero, int estoque, float preço) {
		super();
		this.produto = produto;
		this.Midia = midia;
		this.genero = genero;
		this.estoque = estoque;
		this.preço = preço;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	

	public String getMidia() {
		return Midia;
	}

	public void setMidia(String midia) {
		Midia = midia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}
	

}
