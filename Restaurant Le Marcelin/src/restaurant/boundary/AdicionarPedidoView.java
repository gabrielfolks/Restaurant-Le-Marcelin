package restaurant.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class AdicionarPedidoView {

	private JFrame frmAdicionarPedido;
	private JTable tableIngredientes;
	private JTable tableProdutosPedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarPedidoView window = new AdicionarPedidoView();
					window.frmAdicionarPedido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdicionarPedidoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdicionarPedido = new JFrame();
		frmAdicionarPedido.setTitle("Adicionar Pedido - Restaurant Le Marcelin");
		frmAdicionarPedido.setResizable(false);
		frmAdicionarPedido.setBounds(100, 100, 533, 335);
		frmAdicionarPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdicionarPedido.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 527, 163);
		frmAdicionarPedido.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane);
		
		JPanel panelComidas = new JPanel();
		panelComidas.setBackground(Color.WHITE);
		tabbedPane.addTab("Comidas", null, panelComidas, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panelComidas.setLayout(null);
		
		JComboBox cbPratosDaCasa = new JComboBox();
		cbPratosDaCasa.setModel(new DefaultComboBoxModel(new String[] {"Pratos da Casa"}));
		cbPratosDaCasa.setBounds(154, 11, 213, 20);
		panelComidas.add(cbPratosDaCasa);
		
		tableIngredientes = new JTable();
		tableIngredientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableIngredientes.setBounds(20, 42, 198, 70);
		panelComidas.add(tableIngredientes);
		tableIngredientes.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ingrediente 1", null},
				{"Ingrediente 2", null},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(305, 42, 62, 14);
		panelComidas.add(lblQuantidade);
		
		JSpinner spQuantidade = new JSpinner();
		spQuantidade.setBounds(377, 39, 29, 20);
		panelComidas.add(spQuantidade);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(317, 85, 89, 23);
		panelComidas.add(btnAdicionar);
		tableIngredientes.getColumnModel().getColumn(0).setPreferredWidth(138);
		
		JPanel panelBebidas = new JPanel();
		panelBebidas.setBackground(Color.WHITE);
		tabbedPane.addTab("Bebidas", null, panelBebidas, null);
		panelBebidas.setLayout(null);
		
		JComboBox cbBebidas = new JComboBox();
		cbBebidas.setBounds(150, 11, 214, 20);
		panelBebidas.add(cbBebidas);
		
		JLabel label = new JLabel("Quantidade");
		label.setBounds(242, 45, 83, 20);
		panelBebidas.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(322, 45, 42, 20);
		panelBebidas.add(spinner);
		
		JButton button = new JButton("Adicionar");
		button.setBounds(264, 77, 100, 23);
		panelBebidas.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 162, 527, 88);
		frmAdicionarPedido.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 20, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tableProdutosPedido = new JTable();
		tableProdutosPedido.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"", "Produto", "Qtd."
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProdutosPedido.getColumnModel().getColumn(0).setResizable(false);
		tableProdutosPedido.getColumnModel().getColumn(0).setPreferredWidth(38);
		tableProdutosPedido.getColumnModel().getColumn(1).setPreferredWidth(438);
		scrollPane.setViewportView(tableProdutosPedido);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 260, 527, 43);
		frmAdicionarPedido.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(179, 8, 85, 26);
		panel_2.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(276, 8, 85, 26);
		panel_2.add(btnCancelar);
	}
}
