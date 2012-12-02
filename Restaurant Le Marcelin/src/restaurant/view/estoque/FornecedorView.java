package restaurant.view.estoque;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FornecedorView extends JFrame {

	private JPanel contentPane;
	private JTextField tfRazaoSocial;
	private JTextField tfFantasia;
	private JTextField tfEndereco;
	private JTextField tfCEP;
	private JTextField tfTelefone;
	private JTextField tfCNPJ;
	private JTable table;
	private JTextField tfBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorView frame = new FornecedorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FornecedorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social");
		lblRazoSocial.setBounds(11, 8, 98, 14);
		panel.add(lblRazoSocial);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBounds(119, 5, 406, 20);
		panel.add(tfRazaoSocial);
		tfRazaoSocial.setColumns(50);
		
		JLabel lblFantasia = new JLabel("Fantasia");
		lblFantasia.setBounds(11, 33, 79, 14);
		panel.add(lblFantasia);
		
		tfFantasia = new JTextField();
		tfFantasia.setBounds(119, 36, 406, 20);
		tfFantasia.setColumns(50);
		panel.add(tfFantasia);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 70, 61, 14);
		panel.add(lblEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(119, 67, 406, 20);
		tfEndereco.setColumns(50);
		panel.add(tfEndereco);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(11, 103, 60, 14);
		panel.add(lblCep);
		
		tfCEP = new JTextField();
		tfCEP.setBounds(119, 100, 70, 20);
		panel.add(tfCEP);
		tfCEP.setColumns(8);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(11, 165, 60, 14);
		panel.add(lblTelefone);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(117, 162, 94, 20);
		tfTelefone.setColumns(11);
		panel.add(tfTelefone);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(11, 134, 44, 14);
		panel.add(lblCnpj);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setBounds(119, 131, 118, 20);
		tfCNPJ.setColumns(14);
		panel.add(tfCNPJ);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(11, 213, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(113, 211, 98, 26);
		panel.add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(221, 211, 98, 26);
		panel.add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 680, 133);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Fantasia", "Cnpj", "Telefone", "Endere\u00E7o", "CEP", "Raz\u00E3o Social"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(204);
		table.getColumnModel().getColumn(6).setPreferredWidth(275);
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(442, 144, 98, 26);
		panel_1.add(btnBuscar);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(103, 150, 327, 20);
		panel_1.add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o Nome:");
		lblDigiteONome.setBounds(12, 152, 98, 16);
		panel_1.add(lblDigiteONome);
	}
}
