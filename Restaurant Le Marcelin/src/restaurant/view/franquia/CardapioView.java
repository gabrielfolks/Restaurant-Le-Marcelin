package restaurant.view.franquia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import restaurant.util.DiaSemana;
import restaurant.view.tablemodel.CardapioTableModel;

import javax.swing.JScrollPane;

public class CardapioView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private CardapioTableModel cardapioTableModel;
	private JTextField textField;

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
		setBounds(100, 100, 613, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 10, 524, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(136, 10, 272, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana");
		lblDiaDaSemana.setBounds(10, 8, 91, 14);
		panel_1.add(lblDiaDaSemana);
		
		JComboBox<DiaSemana> cbDiaSemana = new JComboBox<>();
		cbDiaSemana.setModel(new DefaultComboBoxModel<>(DiaSemana.values()));
		cbDiaSemana.setBounds(130, 5, 132, 20);
		panel_1.add(cbDiaSemana);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(26, 51, 464, 262);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 74, 402, 159);
		panel_2.add(scrollPane);
		
		table = new JTable();
		cardapioTableModel = new CardapioTableModel();
		table.setModel(cardapioTableModel);
		
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("C\u00F3digo do Produto");
		label.setBounds(111, 15, 119, 14);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(240, 12, 86, 20);
		panel_2.add(textField);
		
		JButton button = new JButton("Adicionar");
		button.setBounds(177, 40, 119, 23);
		panel_2.add(button);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(94, 309, 338, 47);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(54, 11, 108, 23);
		panel_5.add(btnRemover);
		
		JButton btnSalvar = new JButton("Salvar card\u00E1pio");
		btnSalvar.setBounds(172, 11, 156, 23);
		panel_5.add(btnSalvar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
