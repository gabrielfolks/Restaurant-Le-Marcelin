package restaurant.view.franquia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import restaurant.util.DiaSemana;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class CardapioView extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoProduto;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardapioView frame = new CardapioView();
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
	public CardapioView() {
		setTitle("Cardapio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana");
		panel_1.add(lblDiaDaSemana);
		
		JComboBox cbDiaSemana = new JComboBox();
		panel_1.add(cbDiaSemana);
		cbDiaSemana.setModel(new DefaultComboBoxModel(DiaSemana.values()));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto");
		panel_2.add(lblCdigoDoProduto);
		
		tfCodigoProduto = new JTextField();
		panel_2.add(tfCodigoProduto);
		tfCodigoProduto.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panel_2.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		panel_2.add(btnRemover);
		
		JButton btnSalvar = new JButton("Salvar");
		panel_2.add(btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Valor"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		panel.add(label);
	}

}
