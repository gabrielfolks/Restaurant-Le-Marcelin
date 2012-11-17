package restaurant.view.franquia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import restaurant.util.Cargo;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class FuncionarioView {

	private JFrame frmRestaurantLeMarcelin;
	private JTextField txtId;
	private JTextField tfCTPS;
	private JFormattedTextField tfCPF;
	private JComboBox cbCargo;
	private JTextField tfNome;
	private JTextField tfSalario;
	private JFormattedTextField tfTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView window = new FuncionarioView();
					window.frmRestaurantLeMarcelin.setVisible(true);
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
		frmRestaurantLeMarcelin = new JFrame();
		frmRestaurantLeMarcelin.setTitle("Restaurant Le Marcelin - Funcion\u00E1rio");
		frmRestaurantLeMarcelin.getContentPane().setBackground(Color.WHITE);
		frmRestaurantLeMarcelin.setBounds(100, 100, 569, 488);
		frmRestaurantLeMarcelin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmRestaurantLeMarcelin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRestaurantLeMarcelin.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setBounds(24, 126, 97, 21);
		panel.add(lblFuncionrio);
		lblFuncionrio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		txtId = new JTextField();
		txtId.setBounds(94, 44, 88, 29);
		panel.add(txtId);
		txtId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtId.setColumns(10);
		
		JLabel lblCtps = new JLabel("CTPS");
		lblCtps.setBounds(27, 78, 97, 21);
		panel.add(lblCtps);
		lblCtps.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfCTPS = new JTextField();
		tfCTPS.setBounds(12, 159, 194, 29);
		panel.add(tfCTPS);
		tfCTPS.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCTPS.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(132, 252, 97, 21);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		try {
			tfCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfCPF.setBounds(274, 241, 194, 29);
		panel.add(tfCPF);
		tfCPF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCPF.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(280, 154, 97, 21);
		panel.add(lblCargo);
		lblCargo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		cbCargo = new JComboBox();
		cbCargo.setBounds(303, 131, 194, 29);
		panel.add(cbCargo);
		cbCargo.setModel(new DefaultComboBoxModel(Cargo.values()));
		cbCargo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JLabel lblComisso = new JLabel("Comiss\u00E3o");
		lblComisso.setBounds(276, 90, 97, 21);
		panel.add(lblComisso);
		lblComisso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JTextField tfComissao = new JTextField();
		tfComissao.setBounds(275, 61, 194, 29);
		panel.add(tfComissao);
		tfComissao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfComissao.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(90, 102, 97, 21);
		panel.add(lblEndereo);
		lblEndereo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JTextField tfEndereco = new JTextField();
		tfEndereco.setBounds(206, 110, 440, 29);
		panel.add(tfEndereco);
		tfEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfEndereco.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(135, 120, 97, 21);
		panel.add(lblNome);
		lblNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfNome = new JTextField();
		tfNome.setBounds(192, 314, 344, 29);
		panel.add(tfNome);
		tfNome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfNome.setColumns(10);
		
		JSpinner spinNascimento = new JSpinner();
		spinNascimento.setBounds(168, 356, 131, 29);
		panel.add(spinNascimento);
		spinNascimento.setModel(new SpinnerDateModel(new Date(1352944800000L), new Date(-2208977612000L), null, Calendar.DAY_OF_YEAR));
		spinNascimento.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio");
		lblSalrio.setBounds(32, 296, 97, 21);
		panel.add(lblSalrio);
		lblSalrio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(32, 353, 98, 26);
		panel.add(btnBuscar);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(111, 282, 97, 21);
		panel.add(lblTelefone);
		lblTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfTelefone.setBounds(206, 35, 194, 29);
		panel.add(tfTelefone);
		tfTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfTelefone.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(160, 220, 98, 26);
		panel.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(254, 199, 98, 26);
		panel.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(12, 224, 98, 26);
		panel.add(btnExcluir);
		
		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(0, 0, 97, 21);
		panel.add(lblNascimento);
		lblNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		tfSalario = new JTextField();
		tfSalario.setBounds(185, 12, 194, 29);
		panel.add(tfSalario);
		tfSalario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfSalario.setColumns(10);
	}
}
