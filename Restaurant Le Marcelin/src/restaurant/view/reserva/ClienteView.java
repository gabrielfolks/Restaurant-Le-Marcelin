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

public class ClienteView extends JFrame implements ActionListener {
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
	public ClienteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Restaurant Le Marcelin - Cliente");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		clienteController = new ClienteController();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 784, 540);
		this.getContentPane().add(tabbedPane);
		
		JPanel abaCadastro = new JPanel();
		abaCadastro.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", new ImageIcon(ClienteView.class.getResource("/restaurant/icons/add-icon.png")), abaCadastro, null);
		abaCadastro.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCpf.setBounds(12, 42, 49, 24);
		abaCadastro.add(lblCpf);
		tfCpf = new JFormattedTextField(MascarasCampos.getCPFMask());
		tfCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfCpf.setBounds(134, 42, 206, 24);
		abaCadastro.add(tfCpf);		
		tfCpf.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEndereo.setBounds(12, 78, 119, 24);
		abaCadastro.add(lblEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(134, 77, 554, 24);
		abaCadastro.add(tfEndereco);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(12, 11, 119, 24);
		abaCadastro.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfNome.setColumns(10);
		tfNome.setBounds(134, 7, 307, 24);
		abaCadastro.add(tfNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTelefone.setBounds(12, 113, 119, 24);
		abaCadastro.add(lblTelefone);
		
		tfTelefone = new JFormattedTextField(MascarasCampos.getTelefoneMask());
		tfTelefone.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(134, 112, 146, 24);
		abaCadastro.add(tfTelefone);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 162, 676, 43);
		abaCadastro.add(panel_2);
		
		btnCadastrar = new JButton("Cadastrar cliente");
		btnCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrar.addActionListener(this);
		panel_2.add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar campos");
		btnLimpar.addActionListener(this);
		panel_2.add(btnLimpar);
		
		JPanel abaConsulta = new JPanel();
		abaConsulta.setBackground(Color.WHITE);
		tabbedPane.addTab("Consulta", new ImageIcon(ClienteView.class.getResource("/restaurant/icons/Search-icon.png")), abaConsulta, null);
		abaConsulta.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 757, 243);
		abaConsulta.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		clienteTableModel = new ClienteTableModel();
		table.setModel(clienteTableModel);
			
		scrollPane.setViewportView(table);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(206, 275, 98, 26);
		abaConsulta.add(btnBuscar);
		btnBuscar.addActionListener(this);
		
		tfBusca = new JFormattedTextField();
	
		tfBusca.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfBusca.setColumns(10);
		tfBusca.setBounds(12, 308, 307, 24);
		abaConsulta.add(tfBusca);
		
		rbNome = new JRadioButton("Nome");
		buttonGroup.add(rbNome);
		rbNome.setBackground(Color.WHITE);
		rbNome.setBounds(12, 276, 77, 24);
		abaConsulta.add(rbNome);
		
		rbCPF = new JRadioButton("CPF");
		buttonGroup.add(rbCPF);
		rbCPF.setBackground(Color.WHITE);
		rbCPF.setBounds(93, 276, 65, 24);
		abaConsulta.add(rbCPF);
		
		btnExcluir = new JButton("Excluir cliente");
		btnExcluir.setBounds(489, 277, 161, 23);
		abaConsulta.add(btnExcluir);
		btnExcluir.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Cliente cliente;
		List<Cliente> clientes;
		
		if (arg0.getSource() == btnCadastrar) {
			cliente = new Cliente();
			
			cliente.setNome(tfNome.getText());
			cliente.setCpf((String) tfCpf.getValue());
			cliente.setEndereco(tfEndereco.getText());
			cliente.setTelefone((String) tfTelefone.getValue());
			
			clienteController.adicionar(cliente);
			
			limparCampos();
		}
		
		if (arg0.getSource() == btnBuscar) {
			clientes = new ArrayList<>();
			
			if (rbCPF.isSelected()) {
				cliente = clienteController.pesquisarPorCPF(tfBusca.getText());
					
					if (cliente == null) {
						JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado!");
					} else {
						clienteTableModel.adicionarCliente(cliente);
					}
					
					
			} else if (rbNome.isSelected()) {
				clientes = clienteController.pesquisarPorNome(tfBusca.getText());
				clienteTableModel.adicionarListaDeClientes(clientes);
			}
			
		}
		
		if (arg0.getSource() == btnExcluir) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Escolha uma linha na tabela para excluir");
			} else {
				cliente = clienteTableModel.getCliente(table.getSelectedRow());
				clienteController.remover(cliente);
				clienteTableModel.limpar();
			}
		}
		
		if (arg0.getSource() == btnLimpar) {
			limparCampos();
		}
	}

	private void limparCampos() {
		tfNome.setText("");
		tfCpf.setText("");
		tfEndereco.setText("");
		tfTelefone.setText("");
	}
}
