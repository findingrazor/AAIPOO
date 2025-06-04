package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import controller.ClienteController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

		JLabel lblTitulo = new JLabel("Cadastro Cliente");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitulo.setBounds(224, 32, 236, 40);
		frame.getContentPane().add(lblTitulo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNome.setBounds(40, 137, 62, 31);
		frame.getContentPane().add(lblNome);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCPF.setBounds(40, 214, 48, 31);
		frame.getContentPane().add(lblCPF);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(40, 291, 62, 31);
		frame.getContentPane().add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTelefone.setBounds(40, 368, 92, 31);
		frame.getContentPane().add(lblTelefone);

		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEndereo.setBounds(40, 445, 101, 31);
		frame.getContentPane().add(lblEndereo);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldNome.setBounds(40, 172, 397, 31);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCPF = new JTextField();
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(40, 249, 397, 31);
		frame.getContentPane().add(textFieldCPF);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(40, 326, 397, 31);
		frame.getContentPane().add(textFieldEmail);

		textFieldEndereço = new JTextField();
		textFieldEndereço.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldEndereço.setColumns(10);
		textFieldEndereço.setBounds(40, 477, 397, 31);
		frame.getContentPane().add(textFieldEndereço);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(40, 403, 397, 31);
		frame.getContentPane().add(textFieldTelefone);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (naoVazio() == true && validar() == true) {
					salvar();
				}
			}
		});
		btnSalvar.setForeground(new Color(63, 75, 85));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSalvar.setBounds(47, 598, 132, 40);
		frame.getContentPane().add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setForeground(new Color(63, 75, 85));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLimpar.setBounds(202, 598, 132, 40);
		frame.getContentPane().add(btnLimpar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		btnDeletar.setForeground(new Color(63, 75, 85));
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDeletar.setBounds(352, 598, 132, 40);
		frame.getContentPane().add(btnDeletar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setForeground(new Color(63, 75, 85));
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAtualizar.setBounds(505, 598, 132, 40);
		frame.getContentPane().add(btnAtualizar);

		JLabel lblNewLabel = new JLabel("!: Digite apenas o CPF para deletar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(40, 667, 223, 25);
		frame.getContentPane().add(lblNewLabel);

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
		boolean deletado = controller.deletar(cpf);

		if (!deletado) {
			JOptionPane.showMessageDialog(null, "CPF não encontrado, por favor digite um CPF cadastrado");
			return false;
		} else {
			JOptionPane.showMessageDialog(null, "O cadastro foi deletado com sucesso!");
			limpar();
			return true;
		}
	}

	private boolean atualizar() {
		JOptionPane.showInputDialog(null);
		boolean atualizado = controller.atualizar(textFieldNome.getText(), textFieldCPF.getText(), textFieldEmail.getText(),
				textFieldTelefone.getText(), textFieldEndereço.getText());
		
		if (!atualizado) {
			JOptionPane.showMessageDialog(null, "CPF não encontrado, por favor digite um CPF cadastrado");
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
