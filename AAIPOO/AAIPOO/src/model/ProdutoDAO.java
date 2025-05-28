package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class ProdutoDAO {
	public void salvar(Produto produto) {
		String sql = "INSERT INTO Produto(Produto, Midia, Genero, Estoque, Preço) VALUES (?, ?, ?, ?, ?)";
		Conexao.conectar();
		try(Connection conn = Conexao.conexao; PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, produto.getProduto());
			stmt.setString(2, produto.getMidia());
			stmt.setString(3, produto.getGenero());
			stmt.setInt(4, produto.getEstoque());
			stmt.setFloat(5, produto.getPreço());
			JOptionPane.showMessageDialog(null, stmt.toString());
			stmt.executeUpdate();
			Conexao.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
