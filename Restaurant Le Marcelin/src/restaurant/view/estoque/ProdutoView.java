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

public class ProdutoView {

	private JFrame frmRestaurantLeMarcelin;
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
	public ProdutoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRestaurantLeMarcelin = new JFrame();
		frmRestaurantLeMarcelin.setTitle("Restaurant Le Marcelin - Mercadorias");
		frmRestaurantLeMarcelin.setBounds(100, 100, 804, 465);
		frmRestaurantLeMarcelin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRestaurantLeMarcelin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frmRestaurantLeMarcelin.getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(12, 12, 55, 16);
		panel_1.add(lblCdigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(72, 10, 114, 20);
		panel_1.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 40, 55, 16);
		panel_1.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(72, 38, 491, 20);
		panel_1.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblValorR = new JLabel("Valor");
		lblValorR.setBounds(12, 68, 55, 16);
		panel_1.add(lblValorR);
		
		tfValor = new JFormattedTextField(MascarasCampos.getDinheiroMask());
		tfValor.setBounds(72, 66, 114, 20);
		panel_1.add(tfValor);
		tfValor.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Estoque", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_5.setBounds(312, 70, 251, 105);
		panel_1.add(panel_5);
		
		JLabel lblQtdeAtual = new JLabel("Qtde. Atual");
		panel_5.add(lblQtdeAtual);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_5.add(textField);
		
		JLabel lblQtdeMax = new JLabel("Qtde. Max.");
		panel_5.add(lblQtdeMax);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_5.add(textField_2);
		
		JLabel lblQtdeMin = new JLabel("Qtde. Min.");
		panel_5.add(lblQtdeMin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_5.add(textField_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Busca a Mercadoria pelo ID. Caso n\u00E3o exista, libera para um novo cadastro.");
		btnBuscar.setBounds(198, 7, 98, 26);
		panel_1.add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(12, 175, 98, 26);
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(122, 175, 98, 26);
		panel_1.add(btnExcluir);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Produto", null, panel_3, null);
		panel_3.setLayout(null);
		
		JCheckBox chckbxFabricaoPrpria = new JCheckBox("Fabrica\u00E7\u00E3o Pr\u00F3pria");
		chckbxFabricaoPrpria.setBounds(8, 8, 146, 24);
		panel_3.add(chckbxFabricaoPrpria);
		
		tfMedida = new JTextField();
		tfMedida.setBounds(71, 40, 114, 20);
		panel_3.add(tfMedida);
		tfMedida.setColumns(10);
		
		JLabel label = new JLabel("Medida");
		label.setBounds(8, 40, 55, 16);
		panel_3.add(label);
		
		JComboBox cbMedida = new JComboBox();
		cbMedida.setModel(new DefaultComboBoxModel(Medida.values()));
		cbMedida.setBounds(197, 38, 92, 25);
		panel_3.add(cbMedida);
		
		JLabel lblDescR = new JLabel("Desconto");
		lblDescR.setBounds(8, 72, 55, 16);
		panel_3.add(lblDescR);
		
		tfTaxaDesconto = new JFormattedTextField(MascarasCampos.getDinheiroMask());
		tfTaxaDesconto.setColumns(10);
		tfTaxaDesconto.setBounds(71, 72, 114, 20);
		panel_3.add(tfTaxaDesconto);
		
		JLabel lbl = new JLabel("Tempo Preparo");
		lbl.setBounds(8, 100, 98, 16);
		panel_3.add(lbl);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 98, 114, 20);
		panel_3.add(textField_1);
		
		JLabel lblIngrediente = new JLabel("Ingrediente");
		lblIngrediente.setBounds(317, 12, 71, 16);
		panel_3.add(lblIngrediente);
		
		tfIngrediente = new JTextField();
		tfIngrediente.setToolTipText("Digite o c\u00F3digo do Insumo e preencha no Grid.");
		tfIngrediente.setColumns(10);
		tfIngrediente.setBounds(392, 10, 114, 20);
		panel_3.add(tfIngrediente);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(518, 7, 98, 26);
		panel_3.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(625, 7, 98, 26);
		panel_3.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 37, 453, 136);
		panel_3.add(scrollPane);
		
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
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Insumo", null, panel_4, null);
		panel_4.setLayout(null);
		
		lblUnd = new JLabel();
		lblUnd.setBounds(12, 9, 107, 16);
		lblUnd.setText("Unidade de Medida");
		panel_4.add(lblUnd);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 5, 164, 25);
		comboBox.setModel(new DefaultComboBoxModel(Medida.values()));
		panel_4.add(comboBox);
	}
}
