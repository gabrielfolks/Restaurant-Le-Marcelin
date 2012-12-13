package restaurant.view.franquia;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import restaurant.control.franquia.LoginController;
import restaurant.model.franquia.Login;
import restaurant.view.MenuPrincipalView;

public class LoginView extends JFrame implements ActionListener {

	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnSair;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.setVisible(true);
					window.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		super("");
		setTitle("Login - Restaurant Le Marcelin");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setResizable(false);
		this.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.setBounds(100, 100, 305, 225);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(90, 22, 153, 28);
		this.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsurio.setBounds(31, 28, 49, 14);
		this.getContentPane().add(lblUsurio);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(42, 76, 38, 14);
		this.getContentPane().add(lblNewLabel);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pfSenha.setBounds(90, 69, 153, 28);
		this.getContentPane().add(pfSenha);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(52, 130, 78, 26);
		btnLogin.addActionListener(this);
		this.getContentPane().add(btnLogin);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		btnSair.setBounds(165, 130, 78, 26);
		this.getContentPane().add(btnSair);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLogin) {
			Login l = new Login();
			LoginController lc = new LoginController();
			
			l.setUsuario(tfUsuario.getText());
			pfSenha.getPassword();
			
			if (lc.verificarSenha(l)) {
				this.dispose();
				new MenuPrincipalView();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!",
						"Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		} else if (arg0.getSource() == btnSair) {
			System.exit(0);
		}
		
		
		
	}
}
