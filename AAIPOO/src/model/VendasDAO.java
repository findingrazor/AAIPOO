package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public final class VendasDAO {
	public boolean salvar(Vendas vendas) {
	    String sqlCliente = "SELECT CodCliente FROM Cliente WHERE Nome = ?";
	    String sqlProduto = "SELECT CodProduto FROM Produto WHERE Nome = ?";
	    String sqlPagamento = "SELECT CodPag FROM Pagamento WHERE FormaPag = ?";
	    String inserirPedido = "INSERT INTO Pedido(CodCliente, CodPag) VALUES (?, ?)";
	    String sqlPedido = "SELECT TOP 1 CodPedido FROM Pedido WHERE CodCliente = ? AND CodPag = ? ORDER BY CodPedido DESC";
	    String inserirDetalhes = "INSERT INTO Detalhes(CodPedido, CodProduto, qntdProd, ValorUni, Desconto, ValorTotal) VALUES (?, ?, ?, ?, ?, ?)";

	    Conexao.conectar();

	    try (Connection conn = Conexao.conexao) {
	        int codCliente = -1;
	        int codProduto = -1;
	        int codPagamento = -1;
	        int codPedido = -1;

	        try (PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente)) {
	            stmtCliente.setString(1, vendas.getCliente());
	            ResultSet rs = stmtCliente.executeQuery();
	            if (rs.next()) {
	                codCliente = rs.getInt("CodCliente");
	            } else {
	                JOptionPane.showMessageDialog(null, "Cliente '" + vendas.getCliente() + "' não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto)) {
	            stmtProduto.setString(1, vendas.getProduto());
	            ResultSet rs = stmtProduto.executeQuery();
	            if (rs.next()) {
	                codProduto = rs.getInt("CodProduto");
	            } else {
	                JOptionPane.showMessageDialog(null, "Produto '" + vendas.getProduto() + "' não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmtPag = conn.prepareStatement(sqlPagamento)) {
	            stmtPag.setString(1, vendas.getFormaPag());
	            ResultSet rs = stmtPag.executeQuery();
	            if (rs.next()) {
	                codPagamento = rs.getInt("CodPag");
	            } else {
	                JOptionPane.showMessageDialog(null, "Forma de pagamento '" + vendas.getFormaPag() + "' não encontrada!");
	                return false;
	            }
	        }

	
	        try (PreparedStatement stmtPedido = conn.prepareStatement(inserirPedido)) {
	            stmtPedido.setInt(1, codCliente);
	            stmtPedido.setInt(2, codPagamento);
	            stmtPedido.executeUpdate();
	        }

	        try (PreparedStatement stmtBuscarPedido = conn.prepareStatement(sqlPedido)) {
	            stmtBuscarPedido.setInt(1, codCliente);
	            stmtBuscarPedido.setInt(2, codPagamento);
	            ResultSet rs = stmtBuscarPedido.executeQuery();
	            if (rs.next()) {
	                codPedido = rs.getInt("CodPedido");
	            } else {
	                JOptionPane.showMessageDialog(null, "Erro ao recuperar o código do pedido.");
	                return false;
	            }
	        }

	        try (PreparedStatement stmtDetalhes = conn.prepareStatement(inserirDetalhes)) {
	            stmtDetalhes.setInt(1, codPedido);
	            stmtDetalhes.setInt(2, codProduto);
	            stmtDetalhes.setInt(3, vendas.getQntdProd());
	            stmtDetalhes.setFloat(4, vendas.getValorUni());
	            stmtDetalhes.setFloat(5, vendas.getDesconto());
	            stmtDetalhes.setFloat(6, vendas.getValorTotal());
	            stmtDetalhes.executeUpdate();
	        }

	        return true;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao salvar venda!");
	    } finally {
	        Conexao.desconectar();
	    }

	    return false;
	}

	
	public boolean deletar(String cliente, String produto) {
	    String sqlCliente = "SELECT CodCliente FROM Cliente WHERE Nome = ?";
	    String sqlProduto = "SELECT CodProduto FROM Produto WHERE Nome = ?";
	    String sqlCodPedido = "SELECT D.CodPedido FROM Detalhes D " +
	            "INNER JOIN Pedido P ON D.CodPedido = P.CodPedido " +
	            "WHERE P.CodCliente = ? AND D.CodProduto = ?";
	    String sqlDetalhe = "DELETE FROM Detalhes WHERE CodPedido = ? AND CodProduto = ?";
	    String sqlPedido = "DELETE FROM Pedido WHERE CodPedido = ?";

	    Conexao.conectar();

	    try (Connection conn = Conexao.conexao) {
	        int codCliente = -1;
	        int codProduto = -1;
	        int codPedido = -1;

	        try (PreparedStatement stmt = conn.prepareStatement(sqlCliente)) {
	            stmt.setString(1, cliente);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codCliente = rs.getInt("CodCliente");
	            } else {
	                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlProduto)) {
	            stmt.setString(1, produto);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codProduto = rs.getInt("CodProduto");
	            } else {
	                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlCodPedido)) {
	            stmt.setInt(1, codCliente);
	            stmt.setInt(2, codProduto);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codPedido = rs.getInt("CodPedido");
	            } else {
	                JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlDetalhe)) {
	            stmt.setInt(1, codPedido);
	            stmt.setInt(2, codProduto);
	            stmt.executeUpdate();
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlPedido)) {
	            stmt.setInt(1, codPedido);
	            stmt.executeUpdate();
	        }

	        Conexao.desconectar();
	        return true;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao deletar o pedido!");
	    }

	    return false;
	}

	
	
	public List<Vendas> listar(){
		List<Vendas> lista = new ArrayList<>();
		String sql = "SELECT C.nome AS nomeCliente, P.nome AS nomeProduto, D.qntdProd, D.valorUni, D.desconto, Pa.formaPag,\r\n"
				+ "		D.valorTotal\r\n"
				+ "		FROM detalhes D INNER JOIN produto P ON P.codProduto = D.codProduto\r\n"
				+ "		INNER JOIN pedido Pe ON D.codPedido = Pe.codPedido\r\n"
				+ "		INNER JOIN pagamento Pa ON Pe.codPag = Pa.codPag\r\n"
				+ "		INNER JOIN cliente C ON Pe.codCliente = C.codCliente";
		Conexao.conectar();
		try (Connection conn = Conexao.conexao;
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Vendas vendas = new Vendas(
	                    rs.getString("nomeCliente"),
	                    rs.getString("nomeProduto"),
	                    rs.getInt("qntdProd"),
	                    rs.getFloat("valorUni"),
	                    rs.getFloat("desconto"),
	                    rs.getString("formaPag"),
	                    rs.getFloat("valorTotal")
	                );
	                lista.add(vendas);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	}
	
	public Vendas carregar(String cliente, String produto) {
		Vendas vendas = null;
		String sql = "SELECT C.nome AS nomeCliente, P.nome AS nomeProduto, D.qntdProd, D.valorUni, D.desconto, Pa.formaPag,\r\n"
				+ "		D.valorTotal\r\n"
				+ "		FROM detalhes D INNER JOIN produto P ON P.codProduto = D.codProduto\r\n"
				+ "		INNER JOIN pedido Pe ON D.codPedido = Pe.codPedido\r\n"
				+ "		INNER JOIN pagamento Pa ON Pe.codPag = Pa.codPag\r\n"
				+ "		INNER JOIN cliente C ON Pe.codCliente = C.codCliente"
				+ "     WHERE C.nome = ? AND P.nome = ?";
		Conexao.conectar();
        try (Connection conn = Conexao.conexao;
             PreparedStatement stmt = conn.prepareStatement(sql)){
        	stmt.setString(1, cliente);
        	stmt.setString(2, produto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	vendas = new Vendas(
	                    rs.getString("nomeCliente"),
	                    rs.getString("nomeProduto"),
	                    rs.getInt("qntdProd"),
	                    rs.getFloat("valorUni"),
	                    rs.getFloat("desconto"),
	                    rs.getString("formaPag"),
	                    rs.getFloat("valorTotal")
	                );
	                
            }        
            } catch (SQLException e) {
            e.printStackTrace();
        }
        Conexao.desconectar();
        return vendas;
	}
	
	public boolean atualizar(Vendas venda) {
	    String sqlCliente = "SELECT CodCliente FROM Cliente WHERE Nome = ?";
	    String sqlProduto = "SELECT CodProduto FROM Produto WHERE Nome = ?";
	    String sqlPagamento = "SELECT CodPag FROM Pagamento WHERE FormaPag = ?";
	    String sqlBuscaPedido = "SELECT TOP 1 CodPedido FROM Pedido WHERE CodCliente = ? ORDER BY CodPedido DESC";
	    String sqlDetalhes = "UPDATE Detalhes SET qntdProd = ?, valorUni = ?, desconto = ?, valorTotal = ? WHERE CodPedido = ? AND CodProduto = ?";
	    String sqlPedido = "UPDATE Pedido SET codPag = ? WHERE CodPedido = ?";

	    Conexao.conectar();

	    try (Connection conn = Conexao.conexao) {
	        int codCliente = -1;
	        int codProduto = -1;
	        int codPag = -1;
	        int codPedido = -1;

	        try (PreparedStatement stmt = conn.prepareStatement(sqlCliente)) {
	            stmt.setString(1, venda.getCliente());
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codCliente = rs.getInt("CodCliente");
	            } else {
	                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlProduto)) {
	            stmt.setString(1, venda.getProduto());
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codProduto = rs.getInt("CodProduto");
	            } else {
	                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlPagamento)) {
	            stmt.setString(1, venda.getFormaPag());
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codPag = rs.getInt("CodPag");
	            } else {
	                JOptionPane.showMessageDialog(null, "Forma de pagamento não encontrada!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlBuscaPedido)) {
	            stmt.setInt(1, codCliente);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                codPedido = rs.getInt("CodPedido");
	            } else {
	                JOptionPane.showMessageDialog(null, "Pedido não encontrado para este cliente!");
	                return false;
	            }
	        }

	        try (PreparedStatement stmt = conn.prepareStatement(sqlDetalhes)) {
	            stmt.setInt(1, venda.getQntdProd());
	            stmt.setFloat(2, venda.getValorUni());
	            stmt.setFloat(3, venda.getDesconto());
	            stmt.setFloat(4, venda.getValorTotal());
	            stmt.setInt(5, codPedido); 
	            stmt.setInt(6, codProduto);
	            stmt.executeUpdate();
	        }

	        // Atualizar Pedido
	        try (PreparedStatement stmt = conn.prepareStatement(sqlPedido)) {
	            stmt.setInt(1, codPag);
	            stmt.setInt(2, codPedido); // agora atualizado corretamente
	            stmt.executeUpdate();
	        }

	        Conexao.desconectar();
	        return true;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar a venda.");
	    }

	    return false;
	}




}

