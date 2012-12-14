package restaurant.view.franquia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import restaurant.util.Cargo;
import restaurant.util.DateTextField;
import restaurant.util.MascarasCampos;

public class FuncionarioView {

	private JFrame frmRestaurantLeMarcelin;
	private JTextField tfCTPS;
	private JFormattedTextField tfCPF;
	private JComboBox cbCargo;
	private JTextField tfNome;
	private JTextField tfSalario;
	private JFormattedTextField tfTelefone;
	private JTable table;
	private JTextField tfFiltro;
	private JButton btnBuscar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnLimpar;

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
		frmRestaurantLeMarcelin.setBounds(100, 100, 680, 410);
		frmRestaurantLeMarcelin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmRestaurantLeMarcelin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRestaurantLeMarcelin.getContentPane().add(tabbedPane);
		try {
			MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setValidCharacters("0123456789");
			cpfMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
			telefoneMask.setValidCharacters("0123456789");
			telefoneMask.setValueContainsLiteralCharacters(false);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
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
		try {
			MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setValidCharacters("0123456789");
			cpfMask.setValueContainsLiteralCharacters(false);
			tfCPF = new JFormattedTextField(cpfMask);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		tfCPF.setBounds(99, 82, 194, 29);
		abaCadastro.add(tfCPF);
		tfCPF = new JFormattedTextField(MascarasCampos.getCPFMask());
		tfCPF.setBounds(99, 46, 194, 29);
		abaCadastro.add(tfCPF);
		tfCPF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCPF.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(12, 196, 97, 21);
		abaCadastro.add(lblCargo);
		lblCargo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		cbCargo = new JComboBox<Cargo>();
		cbCargo.setBounds(363, 117, 194, 29);
		abaCadastro.add(cbCargo);
		cbCargo = new JComboBox<Cargo>();
		cbCargo.setBounds(99, 192, 194, 29);
		abaCadastro.add(cbCargo);
		cbCargo.setModel(new DefaultComboBoxModel(Cargo.values()));
		cbCargo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JLabel lblComisso = new JLabel("Comiss\u00E3o");
		lblComisso.setBounds(309, 236, 97, 21);
		abaCadastro.add(lblComisso);
		lblComisso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JTextField tfComissao = new JTextField();
		tfComissao.setBounds(388, 232, 194, 29);
		abaCadastro.add(tfComissao);
		tfComissao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfComissao.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(12, 154, 97, 21);
		abaCadastro.add(lblEndereo);
		lblEndereo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JTextField tfEndereco = new JTextField();
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
		
		JTextField tfDate = new DateTextField();
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
				btnSalvar.setBounds(192, 295, 98, 26);
				abaCadastro.add(btnSalvar);
				
				btnLimpar = new JButton("Limpar");
				btnLimpar.setBounds(360, 295, 98, 26);
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
				
		JPanel abaConsulta = new JPanel();
		tabbedPane.addTab("Consulta", null, abaConsulta, null);
		abaConsulta.setLayout(null);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 637, 243);
		abaConsulta.add(scrollPane);
		
		table = new JTable();
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "CPF", "CTPS", "Cargo", "Sal\u00E1rio", "Comiss\u00E3o", "Nascimento", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Float.class, Float.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(239, 26, 98, 26);
		abaConsulta.add(btnBuscar);
		
		tfFiltro = new JTextField();
		tfFiltro.setBounds(12, 29, 195, 26);
		abaConsulta.add(tfFiltro);
		tfFiltro.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o cpf para buscar");
		lblDigiteONome.setBounds(12, 12, 163, 16);
		abaConsulta.add(lblDigiteONome);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(463, 26, 98, 26);
		abaConsulta.add(btnExcluir);
	}
}
