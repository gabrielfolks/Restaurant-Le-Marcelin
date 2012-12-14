package restaurant.view.franquia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import restaurant.control.franquia.FuncionarioController;
import restaurant.control.franquia.LoginController;
import restaurant.model.franquia.Funcionario;
import restaurant.model.franquia.Login;
import restaurant.util.Cargo;
import restaurant.util.DateTextField;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.FuncionarioTableModel;

public class FuncionarioView extends JFrame implements ActionListener{

	private FuncionarioController funcionarioController;
	private JTextField tfCTPS;
	private JFormattedTextField tfCPF;
	private JComboBox<Cargo> cbCargo;
	private JTextField tfNome;
	private JTextField tfSalario;
	private JFormattedTextField tfTelefone;
	private JTable table;
	private JTextField tfBuscaCPF;
	private JButton btnBuscar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JTextField tfDate;
	private JTextField tfEndereco;
	private JLabel lblComisso;
	private JTextField tfComissao;
	private FuncionarioTableModel funcionarioTableModel;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private LoginController loginController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView window = new FuncionarioView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FuncionarioView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		funcionarioController = new FuncionarioController();
		loginController = new LoginController();
		this.setTitle("Restaurant Le Marcelin - Funcion\u00E1rio");
		this.getContentPane().setBackground(Color.WHITE);
		this.setBounds(100, 100, 825, 477);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane);
		
		JPanel abaCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, abaCadastro, null);
		abaCadastro.setLayout(null);
		
		JLabel lblCtps = new JLabel("CTPS");
		lblCtps.setBounds(12, 85, 97, 21);
		abaCadastro.add(lblCtps);
		lblCtps.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfCTPS = new JTextField();
		tfCTPS.setBounds(99, 81, 194, 29);
		abaCadastro.add(tfCTPS);
		tfCTPS.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCTPS.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(12, 50, 97, 21);
		abaCadastro.add(lblCpf);
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCPF = new JFormattedTextField(MascarasCampos.getCPFMask());
		tfCPF.setBounds(99, 46, 194, 29);
		abaCadastro.add(tfCPF);
		tfCPF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCPF.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(12, 196, 97, 21);
		abaCadastro.add(lblCargo);
		lblCargo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		cbCargo = new JComboBox<>();
		cbCargo.setBounds(99, 192, 194, 29);
		abaCadastro.add(cbCargo);
		cbCargo.setModel(new DefaultComboBoxModel<Cargo>(Cargo.values()));
		cbCargo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblComisso = new JLabel("Comiss\u00E3o");
		lblComisso.setBounds(309, 236, 97, 21);
		abaCadastro.add(lblComisso);
		lblComisso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfComissao = new JTextField();
		tfComissao.setBounds(388, 232, 194, 29);
		abaCadastro.add(tfComissao);
		tfComissao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfComissao.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(12, 154, 97, 21);
		abaCadastro.add(lblEndereo);
		lblEndereo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(99, 150, 440, 29);
		abaCadastro.add(tfEndereco);
		tfEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfEndereco.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 17, 97, 21);
		abaCadastro.add(lblNome);
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfNome = new JTextField();
		tfNome.setBounds(99, 10, 344, 29);
		abaCadastro.add(tfNome);
		tfNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfNome.setColumns(10);
		
				tfDate = new DateTextField();
				tfDate.setBounds(479, 49, 131, 29);
				abaCadastro.add(tfDate);
				
				JLabel lblSalrio = new JLabel("Sal\u00E1rio");
				lblSalrio.setBounds(12, 240, 97, 21);
				abaCadastro.add(lblSalrio);
				lblSalrio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				
				JLabel lblTelefone = new JLabel("Telefone");
				lblTelefone.setBounds(12, 117, 97, 21);
				abaCadastro.add(lblTelefone);
				lblTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				tfTelefone = new JFormattedTextField(MascarasCampos.getTelefoneMask());
				tfTelefone.setBounds(99, 117, 194, 29);
				abaCadastro.add(tfTelefone);
				tfTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				tfTelefone.setColumns(10);
				
				btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(194, 358, 98, 26);
				btnSalvar.addActionListener(this);
				abaCadastro.add(btnSalvar);
				
				btnLimpar = new JButton("Limpar");
				btnLimpar.setBounds(362, 358, 98, 26);
				btnLimpar.addActionListener(this);
				abaCadastro.add(btnLimpar);
				
				JLabel lblNascimento = new JLabel("Data de nascimento");
				lblNascimento.setBounds(318, 53, 151, 21);
				abaCadastro.add(lblNascimento);
				lblNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				
				tfSalario = new JTextField();
				tfSalario.setBounds(99, 236, 194, 29);
				abaCadastro.add(tfSalario);
				tfSalario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				tfSalario.setColumns(10);
				
				tfLogin = new JTextField();
				tfLogin.setBounds(115, 291, 86, 20);
				abaCadastro.add(tfLogin);
				tfLogin.setColumns(10);
				
				tfSenha = new JTextField();
				tfSenha.setBounds(412, 291, 86, 20);
				abaCadastro.add(tfSenha);
				tfSenha.setColumns(10);
				
				JLabel lblSenha = new JLabel("Senha");
				lblSenha.setBounds(336, 294, 46, 14);
				abaCadastro.add(lblSenha);
				
				JLabel lblLogin = new JLabel("Login");
				lblLogin.setBounds(28, 294, 46, 14);
				abaCadastro.add(lblLogin);
		
		JPanel abaConsulta = new JPanel();
		tabbedPane.addTab("Consulta", null, abaConsulta, null);
		abaConsulta.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 744, 298);
		abaConsulta.add(scrollPane);
		
		table = new JTable();
		table.setBorder(null);
		scrollPane.setViewportView(table);
		funcionarioTableModel = new FuncionarioTableModel();
		table.setModel(funcionarioTableModel);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(239, 26, 98, 26);
		abaConsulta.add(btnBuscar);
		
		tfBuscaCPF = new JTextField();
		tfBuscaCPF.setBounds(12, 29, 195, 26);
		abaConsulta.add(tfBuscaCPF);
		tfBuscaCPF.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o cpf para buscar");
		lblDigiteONome.setBounds(12, 12, 163, 16);
		abaConsulta.add(lblDigiteONome);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		btnExcluir.setBounds(463, 26, 98, 26);
		abaConsulta.add(btnExcluir);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Funcionario funcionario;
		Login login;
		
		if (arg0.getSource() == btnSalvar) {
			funcionario = new Funcionario();
			
			funcionario.setNome(tfNome.getText());
			funcionario.setCpf((String) tfCPF.getValue());
			funcionario.setComissao(Float.parseFloat(tfComissao.getText()));	
			funcionario.setCargo((Cargo) cbCargo.getSelectedItem());
			funcionario.setCtps(tfCTPS.getText());
			funcionario.setEndereco(tfEndereco.getText());
				
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascimento;
			
				try {
					dataNascimento = sdf.parse(tfDate.getText());
					funcionario.setNascimento(dataNascimento);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			
			funcionario.setSalario(Float.parseFloat(tfSalario.getText()));
			funcionario.setTelefone((String) tfTelefone.getValue());
				
			login = new Login();
			
			login.setUsuario(tfLogin.getText());
			login.setSenha(tfSenha.getText());
				
			loginController.adicionarLogin(login);
			login = loginController.pesquisarUsuario(login.getUsuario());
				
			funcionario.setLogin(login);
			
			funcionarioController.adicionarFuncionario(funcionario);
			limparCampos();			
			
		} else if (arg0.getSource() == btnLimpar) {
			limparCampos();
			
			
		} else if (arg0.getSource() == btnBuscar) {
			funcionario = funcionarioController.buscarFuncionario(tfBuscaCPF.getText());
			
			if (funcionario == null){
				JOptionPane.showMessageDialog(null, "Funcionário não encontrado", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				funcionarioTableModel.adicionarFuncionario(funcionario);
			}
			
			
		} else if (arg0.getSource() == btnExcluir) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Nenhum funcionário foi selecionado", "Erro!", 
						JOptionPane.ERROR_MESSAGE);
			} else {
				funcionario = funcionarioTableModel.getFuncionario(table.getSelectedRow());
				funcionarioTableModel.removerFuncionario(table.getSelectedRow());
				funcionarioController.removerFuncionario(funcionario);
			}
		}
		
	}

	private void limparCampos() {
		tfNome.setText("");
		tfCPF.setText("");
		tfComissao.setText("");
		cbCargo.setSelectedIndex(-1);
		tfCTPS.setText("");
		tfEndereco.setText("");
		tfDate.setText("");
		tfSalario.setText("");
		tfTelefone.setText("");
	}
}
