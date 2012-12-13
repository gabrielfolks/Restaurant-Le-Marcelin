package restaurant.view.reserva;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import restaurant.control.reserva.ClienteController;
import restaurant.model.reserva.Cliente;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ClienteTableModel;


public class ClienteView implements ActionListener {

	
	private ClienteController clienteController;
	private JFrame frmCliente;
	private JTextField tfCliente;
	private JFormattedTextField tfCpf;
	private JTextField tfEndereco;
	private JTextField tfNome;
	private JFormattedTextField tfTelefone;
	private JTable table;
	private JFormattedTextField tfBusca;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnBuscar;
	private JRadioButton rbCPF;
	private ClienteController clienteController;
	private JButton btnExcluir;
	private JRadioButton rbNome;
	private ClienteTableModel clienteTableModel;
	
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
		
		clienteController = new ClienteController();
		
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
			MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.setValidCharacters("0123456789");
			cpfMask.setValueContainsLiteralCharacters(false);
			tfCpf = new JFormattedTextField(cpfMask);
		} catch (ParseException e) {
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
			MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
			telefoneMask.setValidCharacters("0123456789");
			telefoneMask.setValueContainsLiteralCharacters(false);
			tfTelefone = new JFormattedTextField(telefoneMask);
		} catch (ParseException e) {
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
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		panel_2.add(btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		panel_2.add(btnExcluir);
		
		btnLimpar = new JButton("Limpar");
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(206, 275, 98, 26);
		panel_1.add(btnBuscar);
		
		tfBusca = new JFormattedTextField();
	
		tfBusca.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfBusca.setColumns(10);
		tfBusca.setBounds(12, 308, 307, 24);
		panel_1.add(tfBusca);
		
		JRadioButton rbNome = new JRadioButton("Nome");
		buttonGroup.add(rbNome);
		rbNome.setBackground(Color.WHITE);
		rbNome.setBounds(12, 276, 77, 24);
		panel_1.add(rbNome);
		
		rbCPF = new JRadioButton("CPF");
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Cliente cliente = new Cliente();
		
		if (arg0.getSource() == btnSalvar) {
		
		}
		
		if (arg0.getSource() == btnBuscar) {

		}
		
		if (arg0.getSource() == btnExcluir) {
			
		}
		
		if (arg0.getSource() == btnLimpar) {
			
		}
	}
	
}
