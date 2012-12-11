package restaurant.view.venda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class DeliveryView extends JFrame {

	private JPanel contentPane;
	private JTextField tfCliente;
	private JTextField textField;
	private JTextField txtPrevisao;
	private JTextField textField_1;
	private JTextField txtPrevisaoentrega;
	private JTextField tfTaxaEntrega;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryView frame = new DeliveryView();
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
	public DeliveryView() {
		setTitle("Delivery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(173, 8, 66, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(234, 5, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPreviso = new JLabel("Previs\u00E3o");
		lblPreviso.setBounds(25, 60, 82, 14);
		panel.add(lblPreviso);
		
		txtPrevisao = new JTextField();
		txtPrevisao.setBounds(127, 57, 86, 20);
		panel.add(txtPrevisao);
		txtPrevisao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(244, 60, 66, 14);
		panel.add(lblValor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(299, 57, 147, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(244, 91, 76, 14);
		panel.add(lblCliente);
		
		tfCliente = new JTextField();
		tfCliente.setBounds(299, 88, 118, 20);
		panel.add(tfCliente);
		tfCliente.setColumns(10);
		
		JLabel lblPrevisoEntrega = new JLabel("Previs\u00E3o Entrega");
		lblPrevisoEntrega.setBounds(25, 91, 118, 14);
		panel.add(lblPrevisoEntrega);
		
		txtPrevisaoentrega = new JTextField();
		txtPrevisaoentrega.setBounds(127, 88, 112, 20);
		panel.add(txtPrevisaoentrega);
		txtPrevisaoentrega.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(194, 180, 100, 23);
		panel.add(btnAdicionar);
		
		JLabel lblTaxaEntrega = new JLabel("Taxa Entrega");
		lblTaxaEntrega.setBounds(25, 125, 81, 14);
		panel.add(lblTaxaEntrega);
		
		tfTaxaEntrega = new JTextField();
		tfTaxaEntrega.setColumns(10);
		tfTaxaEntrega.setBounds(127, 122, 86, 20);
		panel.add(tfTaxaEntrega);
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setBounds(42, 184, 34, 14);
		panel.add(lblItem);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(86, 181, 86, 20);
		panel.add(textField_2);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(304, 180, 100, 23);
		panel.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 229, 435, 121);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Item", "Produto", "Quantidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}
}
