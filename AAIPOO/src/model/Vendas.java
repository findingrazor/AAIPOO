package model;

public class Vendas {
	private String cliente;
	private String produto;
	private int qntdProd;
	float valorUni;
	float desconto;
	private String formaPag;
	float valorTotal;
	
	public Vendas(String cliente, String produto, int qntdProd, float valorUni, float desconto, String formaPag,
			float valorTotal) {
		super();
		this.cliente = cliente;
		this.produto = produto;
		this.qntdProd = qntdProd;
		this.valorUni = valorUni;
		this.desconto = desconto;
		this.formaPag = formaPag;
		this.valorTotal = valorTotal;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQntdProd() {
		return qntdProd;
	}

	public void setQntdProd(int qntdProd) {
		this.qntdProd = qntdProd;
	}

	public float getValorUni() {
		return valorUni;
	}

	public void setValorUni(float valorUni) {
		this.valorUni = valorUni;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public String getFormaPag() {
		return formaPag;
	}

	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	
}	