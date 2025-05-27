package view;
 
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
 
public class TelaProduto {
 
	private JFrame frame;
	private JTextField textFieldProduto;
	private JLabel lblProduto;
	private JLabel lblMidia;
	private JTextField textFieldEstoque;
	private JTextField textFieldPreço;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProduto window = new TelaProduto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 */
	public TelaProduto() {
		initialize();
	}
        
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(63, 75, 85));
		frame.setBounds(0, 0, 700, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(30, 156, 416, 31);
		frame.getContentPane().add(textFieldProduto);
		textFieldProduto.setColumns(10);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setForeground(Color.WHITE);
		lblCadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblCadastroProduto.setBounds(224, 29, 260, 40);
		frame.getContentPane().add(lblCadastroProduto);
		
		lblProduto = new JLabel("Produto");
		lblProduto.setForeground(Color.WHITE);
		lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProduto.setBounds(30, 121, 136, 31);
		frame.getContentPane().add(lblProduto);
		
		lblMidia = new JLabel("Mídia");
		lblMidia.setForeground(Color.WHITE);
		lblMidia.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMidia.setBounds(30, 198, 136, 31);
		frame.getContentPane().add(lblMidia);
		
		JComboBox comboBoxMidia = new JComboBox();
		comboBoxMidia.setModel(new DefaultComboBoxModel(new String[] {"Selecione um tipo", "CD", "DVD", "LP"}));
		comboBoxMidia.setBounds(30, 233, 141, 31);
		frame.getContentPane().add(comboBoxMidia);
		
		JLabel lblGenero = new JLabel("Gênero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGenero.setBounds(286, 198, 136, 31);
		frame.getContentPane().add(lblGenero);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"Selecione o genero", "Rock", "MPB", "Pop", "Indie"}));
		comboBoxGenero.setBounds(286, 233, 160, 31);
		frame.getContentPane().add(comboBoxGenero);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setForeground(Color.WHITE);
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEstoque.setBounds(30, 275, 136, 31);
		frame.getContentPane().add(lblEstoque);
		
		textFieldEstoque = new JTextField();
		textFieldEstoque.setColumns(10);
		textFieldEstoque.setBounds(30, 307, 141, 31);
		frame.getContentPane().add(textFieldEstoque);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setForeground(Color.WHITE);
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPreo.setBounds(286, 276, 136, 31);
		frame.getContentPane().add(lblPreo);
		
		textFieldPreço = new JTextField();
		textFieldPreço.setColumns(10);
		textFieldPreço.setBounds(286, 307, 160, 31);
		frame.getContentPane().add(textFieldPreço);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(63, 75, 85));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSalvar.setBounds(47, 598, 132, 40);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(63, 75, 85));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLimpar.setBounds(202, 598, 132, 40);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(new Color(63, 75, 85));
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDeletar.setBounds(352, 598, 132, 40);
		frame.getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");	
		btnAtualizar.setForeground(new Color(63, 75, 85));
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAtualizar.setBounds(505, 598, 132, 40);
		frame.getContentPane().add(btnAtualizar);
	}
}
