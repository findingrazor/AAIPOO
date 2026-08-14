package model;

public class Midia {
	private int codMidia;
	private String midia;
	
	public Midia(int codMidia, String midia) {
		super();
		this.codMidia = codMidia;
		this.midia = midia;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public int getCodMidia() {
		return codMidia;
	}

	public void setCodMidia(int codMidia) {
		this.codMidia = codMidia;
	}

	
}
