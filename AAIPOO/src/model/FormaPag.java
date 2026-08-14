package model;

public class FormaPag {
	private int codPag;
	private String formaPag;
	
	public FormaPag(int codPag, String formaPag) {
		super();
		this.codPag = codPag;
		this.formaPag = formaPag;
	}

	public int getCodPag() {
		return codPag;
	}

	public void setCodPag(int codPag) {
		this.codPag = codPag;
	}

	public String getFormaPag() {
		return formaPag;
	}

	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}
	
	
}
