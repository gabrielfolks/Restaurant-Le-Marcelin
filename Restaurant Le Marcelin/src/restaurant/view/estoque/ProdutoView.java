package restaurant.view.estoque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import restaurant.util.MascarasCampos;
import restaurant.util.Medida;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class ProdutoView extends JFrame implements ActionListener {

	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfMedida;
	private JTextField tfTaxaDesconto;
	private JTextField textField_1;
	private JTextField tfIngrediente;
	private JTable table;
	private JLabel lblUnd;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView window = new ProdutoView();
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
	public ProdutoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Restaurant Le Marcelin - Mercadorias");
		this.setBounds(100, 100, 804, 465);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel painelProduto = new JPanel();
		panel.add(painelProduto);
		painelProduto.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(12, 12, 55, 16);
		painelProduto.add(lblCdigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(72, 10, 114, 20);
		painelProduto.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 40, 55, 16);
		painelProduto.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(72, 38, 491, 20);
		painelProduto.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblValorR = new JLabel("Valor");
		lblValorR.setBounds(12, 68, 55, 16);
		painelProduto.add(lblValorR);
		
		tfValor = new JFormattedTextField(MascarasCampos.getDinheiroMask());
		tfValor.setBounds(72, 66, 114, 20);
		painelProduto.add(tfValor);
		tfValor.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Estoque", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_5.setBounds(312, 70, 293, 111);
		painelProduto.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 2));
		
		JLabel lblQtdeAtual = new JLabel("Quantidade atual");
		panel_5.add(lblQtdeAtual);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_5.add(textField);
		
		JLabel lblQtdeMax = new JLabel("Quantidade m\u00E1xima");
		panel_5.add(lblQtdeMax);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_5.add(textField_2);
		
		JLabel lblQtdeMin = new JLabel("Quantidade m\u00EDnima");
		panel_5.add(lblQtdeMin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_5.add(textField_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Busca a Mercadoria pelo ID. Caso n\u00E3o exista, libera para um novo cadastro.");
		btnBuscar.setBounds(198, 7, 98, 26);
		painelProduto.add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(12, 175, 98, 26);
		painelProduto.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(122, 175, 98, 26);
		painelProduto.add(btnExcluir);
		
		JPanel painelIngrediente = new JPanel();
		panel.add(painelIngrediente);
		painelIngrediente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		painelIngrediente.add(tabbedPane_1);
		
		JPanel abaProduto = new JPanel();
		tabbedPane_1.addTab("Produto", null, abaProduto, null);
		abaProduto.setLayout(null);
		
		JCheckBox chckbxFabricaoPrpria = new JCheckBox("Fabrica\u00E7\u00E3o Pr\u00F3pria");
		chckbxFabricaoPrpria.setBounds(8, 8, 146, 24);
		abaProduto.add(chckbxFabricaoPrpria);
		
		tfMedida = new JTextField();
		tfMedida.setBounds(71, 40, 114, 20);
		abaProduto.add(tfMedida);
		tfMedida.setColumns(10);
		
		JLabel label = new JLabel("Medida");
		label.setBounds(8, 40, 55, 16);
		abaProduto.add(label);
		
		JComboBox cbMedida = new JComboBox();
		cbMedida.setModel(new DefaultComboBoxModel(Medida.values()));
		cbMedida.setBounds(197, 38, 92, 25);
		abaProduto.add(cbMedida);
		
		JLabel lblDescR = new JLabel("Desconto");
		lblDescR.setBounds(8, 72, 55, 16);
		abaProduto.add(lblDescR);
		
		tfTaxaDesconto = new JFormattedTextField(MascarasCampos.getDinheiroMask());
		tfTaxaDesconto.setColumns(10);
		tfTaxaDesconto.setBounds(71, 72, 114, 20);
		abaProduto.add(tfTaxaDesconto);
		
		JLabel lbl = new JLabel("Tempo Preparo");
		lbl.setBounds(8, 100, 98, 16);
		abaProduto.add(lbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 98, 114, 20);
		abaProduto.add(textField_1);
		
		JLabel lblIngrediente = new JLabel("Ingrediente");
		lblIngrediente.setBounds(317, 12, 71, 16);
		abaProduto.add(lblIngrediente);
		
		tfIngrediente = new JTextField();
		tfIngrediente.setToolTipText("Digite o c\u00F3digo do Insumo e preencha no Grid.");
		tfIngrediente.setColumns(10);
		tfIngrediente.setBounds(392, 10, 114, 20);
		abaProduto.add(tfIngrediente);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(518, 7, 98, 26);
		abaProduto.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(625, 7, 98, 26);
		abaProduto.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 37, 453, 136);
		abaProduto.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, ""},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Quantidade", "Medida"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Float.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JPanel abaInsumo = new JPanel();
		tabbedPane_1.addTab("Insumo", null, abaInsumo, null);
		abaInsumo.setLayout(null);
		
		lblUnd = new JLabel();
		lblUnd.setBounds(12, 9, 107, 16);
		lblUnd.setText("Unidade de Medida");
		abaInsumo.add(lblUnd);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 5, 164, 25);
		comboBox.setModel(new DefaultComboBoxModel(Medida.values()));
		abaInsumo.add(comboBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
