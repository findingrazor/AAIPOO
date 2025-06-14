package controller;

import java.util.List;

import model.Cliente;
import model.ClienteDAO;

public class ClienteController {
	ClienteDAO dao = new ClienteDAO();
	
	public void salvar(String nome, String cpf, String email, String telefone, String endereco) {
		Cliente cliente = new Cliente(nome, cpf, email, telefone, endereco);
		dao.salvar(cliente);
	}
	
	public boolean deletar(String cpf) {
		return dao.deletarPorCpf(cpf);
	}
	
	public boolean atualizar(String nome, String cpf, String email, String telefone, String endereco) {
		Cliente cliente = new Cliente(nome, cpf, email, telefone, endereco);
		return dao.atualizar(cliente);
	}
	
	public Cliente carregar(String cpf) {
		return dao.carregar(cpf);
	}
}
