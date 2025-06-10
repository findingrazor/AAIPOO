package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import controller.ClienteController;
import model.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import java.awt.Panel;

public class TelaCliente {

	private JFrame frame;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JTextField textFieldEndereço;
	private JTextField textFieldTelefone;

	private ClienteController controller = new ClienteController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		try {
		    UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch( Exception ex ) {
		    System.err.println( "Failed to initialize LaF" );
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente window = new TelaCliente();
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
	public TelaCliente() {
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

		JLabel lblTitulo = new JLabel("Gerenciamento Clientes");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitulo.setBounds(171, 28, 339, 40);
		frame.getContentPane().add(lblTitulo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(27, 143, 62, 31);
		frame.getContentPane().add(lblNome);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCPF.setBounds(27, 229, 41, 31);
		frame.getContentPane().add(lblCPF);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(27, 313, 62, 31);
		frame.getContentPane().add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(27, 398, 92, 31);
		frame.getContentPane().add(lblTelefone);

		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEndereo.setBounds(27, 480, 101, 31);
		frame.getContentPane().add(lblEndereo);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldNome.setBounds(27, 172, 397, 31);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCPF = new JTextField();
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(27, 256, 397, 31);
		frame.getContentPane().add(textFieldCPF);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(27, 340, 397, 31);
		frame.getContentPane().add(textFieldEmail);

		textFieldEndereço = new JTextField();
		textFieldEndereço.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldEndereço.setColumns(10);
		textFieldEndereço.setBounds(27, 508, 397, 31);
		frame.getContentPane().add(textFieldEndereço);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(27, 424, 397, 31);
		frame.getContentPane().add(textFieldTelefone);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastra um novo cliente no banco");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (naoVazio() == true && validar() == true) {
					salvar();
				}
			}
		});
		btnCadastrar.setForeground(new Color(63, 75, 85));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBounds(525, 324, 108, 31);
		frame.getContentPane().add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setToolTipText("Apaga todos os campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setForeground(new Color(63, 75, 85));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLimpar.setBounds(525, 375, 108, 31);
		frame.getContentPane().add(btnLimpar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setToolTipText("Deleta um cadastro por CPF (somente CPF necessário)");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnDeletar.setForeground(new Color(63, 75, 85));
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeletar.setBounds(525, 273, 108, 31);
		frame.getContentPane().add(btnDeletar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setToolTipText("Atualiza dados de um cadastro por CPF (preencha todos os campos)");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setForeground(new Color(63, 75, 85));
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAtualizar.setBounds(525, 222, 108, 31);
		frame.getContentPane().add(btnAtualizar);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setToolTipText("Preeenche todos os campos com dados de um CPF");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregar();
			}
		});
		btnCarregar.setForeground(new Color(63, 75, 85));
		btnCarregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCarregar.setBounds(525, 171, 108, 31);
		frame.getContentPane().add(btnCarregar);
		
		JButton btnAjuda = new JButton("Ajuda");
		btnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ações dos Botões\n"
						+ "Carregar - Preeenche todos os campos com dados de um CPF\n"
						+ "Atualizar - Atualiza dados de um cadastro por CPF (preencha todos os campos)\n"
						+ "Deletar - Deleta um cadastro por CPF (somente CPF necessário)\n"
						+ "Cadastrar - Cadastra um novo cliente no banco\n"
						+ "Limpar - Apaga todos os campos");
			}
		});
		btnAjuda.setBounds(585, 727, 89, 23);
		frame.getContentPane().add(btnAjuda);

	}

	private void salvar() {
		controller.salvar(textFieldNome.getText(), textFieldCPF.getText(), textFieldEmail.getText(),
				textFieldTelefone.getText(), textFieldEndereço.getText());
		JOptionPane.showMessageDialog(null, "O cadastro foi feito com sucesso!");
		limpar();
	}

	private void limpar() {
		textFieldNome.setText("");
		textFieldCPF.setText("");
		textFieldEmail.setText("");
		textFieldEndereço.setText("");
		textFieldTelefone.setText("");
	}

	private boolean deletar() {
		String cpf = textFieldCPF.getText();
		if(textFieldCPF.getText().isBlank()) {
			cpf = JOptionPane.showInputDialog("Digite o CPF que deseja deletar: ",null);
		} 
		
		boolean deletado = controller.deletar(cpf);

		if (!deletado) {
			JOptionPane.showMessageDialog(null, "CPF não encontrado, por favor digite um CPF cadastrado ou válido");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "O cadastro foi deletado com sucesso!");
			limpar();
			return true;
		}
	}
	
	private Cliente carregar() {
		String cpf = JOptionPane.showInputDialog("Digite o CPF que deseja carregar: ",null);
		Cliente cliente = controller.carregar(cpf);
		
		
		textFieldNome.setText(cliente.getNome());
		textFieldCPF.setText(cliente.getCpf());
		textFieldEmail.setText(cliente.getEmail());
		textFieldEndereço.setText(cliente.getEndereco());
		textFieldTelefone.setText(cliente.getTelefone());
		
		return cliente;
	}
	private boolean atualizar() {
		boolean atualizado = controller.atualizar(textFieldNome.getText(), textFieldCPF.getText(), textFieldEmail.getText(),
				textFieldTelefone.getText(), textFieldEndereço.getText());
		
		if(textFieldCPF.getText().isBlank()) {
			String cpf = JOptionPane.showInputDialog("Digite o CPF que atualizar deletar: ",null);
			atualizado = controller.atualizar(textFieldNome.getText(), cpf, textFieldEmail.getText(),
					textFieldTelefone.getText(), textFieldEndereço.getText());
		}
		
		if (!atualizado) {
			JOptionPane.showMessageDialog(null, "CPF não encontrado, por favor digite um CPF cadastrado ou válido");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "O cadastro foi atualizado com sucesso!");
			limpar();
			return true;
		}
	}

	private boolean naoVazio() {
		JTextField[] campos = { textFieldNome, textFieldCPF, textFieldEmail, textFieldEndereço, textFieldTelefone };
		String[] nomesCampos = { "Nome", "CPF", "E-mail", "Endereço", "Telefone" };
		for (int i = 0; i < campos.length; i++) {
			if (campos[i].getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "O campo " + nomesCampos[i] + " está vazio, por favor, preencha-o");
				return false;
			}
		}
		return true;
	}

	private boolean validar() {
		JTextField[] campos = { textFieldNome, textFieldCPF, textFieldEmail, textFieldEndereço, textFieldTelefone };

		if (!campos[1].getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "CPF inválido, por favor digite apenas números");
			return false;
		} else if (campos[1].getText().length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF inválido, por favor digite um número válido (11 caracteres)");
			return false;
		}

		if (!campos[2].getText().contains("@") || !campos[2].getText().contains(".com")) {
			JOptionPane.showMessageDialog(null, "Email inválido, por favor digite um email com pelo menos @ e .com");
			return false;
		}

		if (!campos[4].getText().matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "Telefone inválido, por favor digite apenas números");
			return false;
		} else if (campos[4].getText().length() != 11) {
			JOptionPane.showMessageDialog(null, "Telefone inválido, por favor digite um número válido (11 caracteres)");
			return false;
		}

		return true;
	}
}
