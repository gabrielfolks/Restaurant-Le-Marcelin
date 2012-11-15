package restaurant.view.reserva;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ClienteView {

	private JFrame frmCliente;
	private JTextField tfCliente;
	private JFormattedTextField tfCpf;
	private JTextField tfEndereco;
	private JTextField tfNome;
	private JFormattedTextField tfTelefone;
	private JTable table;
	private JTextField tfBusca;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView window = new ClienteView();
					window.frmCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClienteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCliente = new JFrame();
		frmCliente.setTitle("Restaurant Le Marcelin - Cliente");
		frmCliente.setBounds(100, 100, 800, 600);
		frmCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCliente.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 784, 540);
		frmCliente.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", new ImageIcon(ClienteView.class.getResource("/restaurant/icons/add-icon.png")), panel, null);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCliente.setBounds(12, 7, 67, 16);
		panel.add(lblCliente);
		
		tfCliente = new JTextField();
		tfCliente.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfCliente.setBounds(134, 7, 206, 24);
		panel.add(tfCliente);
		tfCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCpf.setBounds(12, 42, 49, 24);
		panel.add(lblCpf);
		
		try {
			tfCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfCpf.setBounds(134, 42, 206, 24);
		panel.add(tfCpf);		
		tfCpf.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEndereo.setBounds(12, 114, 119, 24);
		panel.add(lblEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(134, 114, 554, 24);
		panel.add(tfEndereco);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(12, 78, 119, 24);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfNome.setColumns(10);
		tfNome.setBounds(134, 78, 307, 24);
		panel.add(tfNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTelefone.setBounds(12, 150, 119, 24);
		panel.add(lblTelefone);
		
		try {
			tfTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(134, 150, 307, 24);
		panel.add(tfTelefone);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 196, 676, 43);
		panel.add(panel_2);
		
		JButton btnSalvar = new JButton("Salvar");
		panel_2.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		panel_2.add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		panel_2.add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Consulta", new ImageIcon(ClienteView.class.getResource("/restaurant/icons/Search-icon.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 757, 243);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "CPF", "Endere\u00E7o", "Telefone"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(206, 275, 98, 26);
		panel_1.add(btnBuscar);
		
		tfBusca = new JTextField();
		tfBusca.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfBusca.setColumns(10);
		tfBusca.setBounds(12, 308, 307, 24);
		panel_1.add(tfBusca);
		
		JRadioButton rbNome = new JRadioButton("Nome");
		buttonGroup.add(rbNome);
		rbNome.setBackground(Color.WHITE);
		rbNome.setBounds(12, 276, 77, 24);
		panel_1.add(rbNome);
		
		JRadioButton rbCPF = new JRadioButton("CPF");
		buttonGroup.add(rbCPF);
		rbCPF.setBackground(Color.WHITE);
		rbCPF.setBounds(93, 276, 65, 24);
		panel_1.add(rbCPF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(215);
		table.getColumnModel().getColumn(2).setPreferredWidth(178);
		table.getColumnModel().getColumn(3).setPreferredWidth(359);
		table.getColumnModel().getColumn(4).setPreferredWidth(153);
	}
}
