package model;

public class Genero {
	private int codGenero;
	private String genero;

	public Genero(int codGenero, String genero) {
		super();
		this.codGenero = codGenero;
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(int codGenero) {
		this.codGenero = codGenero;
	}
	
	
}
