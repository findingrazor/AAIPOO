package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereço;
	private JTextField textFieldTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente window = new CadastroCliente();
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
	public CadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(63, 75, 85));
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Cadastro Cliente");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitulo.setBounds(212, 104, 256, 40);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNome.setBounds(205, 244, 70, 31);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCPF.setBounds(228, 369, 48, 31);
		frame.getContentPane().add(lblCPF);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(213, 482, 62, 31);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTelefone.setBounds(174, 607, 101, 31);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEndereo.setBounds(159, 720, 116, 31);
		frame.getContentPane().add(lblEndereo);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldNome.setBounds(286, 239, 550, 42);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(286, 358, 292, 42);
		frame.getContentPane().add(textFieldCPF);
		//validar
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(286, 477, 455, 42);
		frame.getContentPane().add(textFieldEmail);
		//validar
		
		textFieldEndereço = new JTextField();
		textFieldEndereço.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldEndereço.setColumns(10);
		textFieldEndereço.setBounds(286, 715, 455, 42);
		frame.getContentPane().add(textFieldEndereço);
		//validar
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(286, 596, 292, 42);
		frame.getContentPane().add(textFieldTelefone);
		//validar
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(63, 75, 85));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSalvar.setBounds(655, 874, 214, 67);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLimpar.setForeground(new Color(63, 75, 85));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLimpar.setBounds(948, 874, 214, 67);
		frame.getContentPane().add(btnLimpar);
		//limpar 
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(new Color(63, 75, 85));
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDeletar.setBounds(1241, 874, 214, 67);
		frame.getContentPane().add(btnDeletar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setForeground(new Color(63, 75, 85));
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAtualizar.setBounds(1534, 874, 214, 67);
		frame.getContentPane().add(btnAtualizar);
	}
}
