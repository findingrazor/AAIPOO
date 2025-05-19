package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
	public void salvar(Cliente cliente) {
		String sql = "INSERT INTO Cliente(Nome, CPF, Email, Telefone, Endereço) VALUES (?, ?, ?, ?, ?)";
		Conexao.conectar();
		try(Connection conn = Conexao.conexao; PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getEndereco());
			stmt.executeUpdate();
			Conexao.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
