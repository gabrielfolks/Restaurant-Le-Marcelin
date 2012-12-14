package restaurant.view.estoque;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import restaurant.control.estoque.FornecedorController;
import restaurant.model.estoque.Fornecedor;
import restaurant.util.MascarasCampos;

public class FornecedorView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfRazaoSocial;
	private JTextField tfFantasia;
	private JTextField tfEndereco;
	private JFormattedTextField tfCEP;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCNPJ;
	private JTable table;
	private JTextField tfBuscar;
	private JButton btnExcluir;
	private JButton btnBuscar;
	private JButton btnLimpar;
	private JButton btnCadastrar;

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
		
		JPanel abaCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, abaCadastro, null);
		abaCadastro.setLayout(null);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social");
		lblRazoSocial.setBounds(11, 8, 98, 14);
		abaCadastro.add(lblRazoSocial);
		
		tfRazaoSocial = new JTextField();
		tfRazaoSocial.setBounds(119, 5, 406, 20);
		abaCadastro.add(tfRazaoSocial);
		tfRazaoSocial.setColumns(50);
		
		JLabel lblFantasia = new JLabel("Fantasia");
		lblFantasia.setBounds(10, 39, 79, 14);
		abaCadastro.add(lblFantasia);
		
		tfFantasia = new JTextField();
		tfFantasia.setBounds(119, 36, 406, 20);
		tfFantasia.setColumns(50);
		abaCadastro.add(tfFantasia);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 70, 61, 14);
		abaCadastro.add(lblEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setBounds(119, 67, 406, 20);
		tfEndereco.setColumns(50);
		abaCadastro.add(tfEndereco);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(11, 103, 60, 14);
		abaCadastro.add(lblCep);
		
		tfCEP = new JFormattedTextField(MascarasCampos.getCEPMask());
		tfCEP.setBounds(119, 100, 70, 20);
		abaCadastro.add(tfCEP);
		tfCEP.setColumns(8);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(11, 165, 60, 14);
		abaCadastro.add(lblTelefone);
		
		tfTelefone = new JFormattedTextField(MascarasCampos.getTelefoneMask());
		tfTelefone.setBounds(117, 162, 94, 20);
		tfTelefone.setColumns(11);
		abaCadastro.add(tfTelefone);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(11, 134, 44, 14);
		abaCadastro.add(lblCnpj);
		
		tfCNPJ = new JFormattedTextField(MascarasCampos.getCNPJMask());
		tfCNPJ.setBounds(119, 131, 118, 20);
		tfCNPJ.setColumns(14);
		abaCadastro.add(tfCNPJ);
		
		btnCadastrar = new JButton("Cadastrar fornecedor");
		btnCadastrar.setBounds(192, 219, 170, 26);
		abaCadastro.add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar campos");
		btnLimpar.setBounds(228, 335, 103, 26);
		abaCadastro.add(btnLimpar);
		
		JPanel abaConsulta = new JPanel();
		tabbedPane.addTab("Consulta", null, abaConsulta, null);
		abaConsulta.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 5, 680, 133);
		abaConsulta.add(scrollPane);
		
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
		
		btnExcluir = new JButton("Excluir fornecedor");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(452, 146, 174, 26);
		abaConsulta.add(btnExcluir);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(256, 146, 98, 26);
		abaConsulta.add(btnBuscar);
		
		tfBuscar = new JTextField();
		tfBuscar.setBounds(48, 149, 186, 20);
		abaConsulta.add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JLabel lblCNPJBusca = new JLabel("CNPJ:");
		lblCNPJBusca.setBounds(12, 152, 98, 16);
		abaConsulta.add(lblCNPJBusca);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FornecedorController fc = new FornecedorController();
		Fornecedor f = new Fornecedor();
		
		if (arg0.getSource() == btnCadastrar) {
			f.setNome(tfFantasia.getText());
			f.setRazaoSocial(tfRazaoSocial.getText());
			f.setEndereco(tfEndereco.getText());
			f.setCep((String) tfCEP.getValue());
			f.setCnpj((String) tfCNPJ.getValue());
			f.setTelefone((String) tfTelefone.getValue());		
			
			fc.adicionarFornecedor(f);
			
			limparCampos();
		}
		
		if (arg0.getSource() == btnBuscar) {
			
		}
		
		if (arg0.getSource() == btnExcluir) {
			
		}
		
		if (arg0.getSource() == btnLimpar) {
			limparCampos();
		}
		
		
	}

	private void limparCampos() {
		tfFantasia.setText("");
		tfRazaoSocial.setText("");
		tfEndereco.setText("");
		tfCEP.setText("");
		tfCNPJ.setText("");
		tfTelefone.setText("");
	}
		
	
}
