ackage model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public void deletarPorCpf(String cpf) {
        String sql = "DELETE FROM Cliente WHERE CPF = ?";
        Conexao.conectar();
        try (Connection conn = Conexao.conexao;
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            Conexao.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean cpfExiste(String cpf) {
	    String sql = "SELECT 1 FROM Cliente WHERE CPF = ?";
	    Conexao.conectar();
	    try (Connection conn = Conexao.conexao;
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, cpf);
	        var rs = stmt.executeQuery();
	        return rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Conexao.desconectar(); 
	    }
	    return false;
	}
}
