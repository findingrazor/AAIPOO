package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			//JOptionPane.showMessageDialog(null, stmt.toString());
			stmt.executeUpdate();
			Conexao.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean deletarPorCpf(String cpf) {
        String sql = "DELETE FROM Cliente WHERE CPF = ?";
        Conexao.conectar();
        try (Connection conn = Conexao.conexao;
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	Conexao.desconectar();
        }
        return false;
    }
	
	public boolean atualizar(Cliente cliente) {
		String sql = "UPDATE cliente SET Nome = ?, Email = ?, Telefone = ?, Endereço = ? "
				+ "WHERE CPF = ?";
		Conexao.conectar();
		try(Connection conn = Conexao.conexao; PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getCpf());
			int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	Conexao.desconectar();
        }
        return false;
	}
	
	public Cliente carregar(String cpf) {
		Cliente cliente = null;
		String sql = "SELECT * FROM Cliente WHERE CPF = ?";
        Conexao.conectar();
        try (Connection conn = Conexao.conexao;
             PreparedStatement stmt = conn.prepareStatement(sql)){
        	stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(
                    rs.getString("Nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("endereço")   
                );
            }        
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
