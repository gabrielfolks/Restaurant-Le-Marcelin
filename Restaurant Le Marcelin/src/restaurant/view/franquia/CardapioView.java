package restaurant.view.franquia;

import java.awt.EventQueue;
<<<<<<< HEAD
=======
import java.awt.FlowLayout;
>>>>>>> refs/remotes/origin/view
import java.awt.GridLayout;
<<<<<<< HEAD

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import restaurant.util.DiaSemana;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
>>>>>>> refs/remotes/origin/view

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
<<<<<<< HEAD
	private JTextField tfCodigoProduto;
=======
	private JTable table;
	private CardapioTableModel cardapioTableModel;
	private JTextField textField;
>>>>>>> refs/remotes/origin/view

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
<<<<<<< HEAD
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
=======
		contentPane.setLayout(null);
>>>>>>> refs/remotes/origin/view
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 10, 524, 367);
		contentPane.add(panel);
<<<<<<< HEAD
		panel.setLayout(new BorderLayout(0, 0));
=======
		panel.setLayout(null);
>>>>>>> refs/remotes/origin/view
		
		JPanel panel_1 = new JPanel();
<<<<<<< HEAD
		panel.add(BorderLayout.NORTH, panel_1);
=======
		panel_1.setBounds(136, 10, 272, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
>>>>>>> refs/remotes/origin/view
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana");
		lblDiaDaSemana.setBounds(10, 8, 91, 14);
		panel_1.add(lblDiaDaSemana);
		
		JComboBox<DiaSemana> cbDiaSemana = new JComboBox<>();
		cbDiaSemana.setModel(new DefaultComboBoxModel<>(DiaSemana.values()));
		cbDiaSemana.setBounds(130, 5, 132, 20);
		panel_1.add(cbDiaSemana);
		
		JPanel panel_2 = new JPanel();
<<<<<<< HEAD
		panel.add(BorderLayout.CENTER, panel_2);
		panel_2.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto");
		panel_4.add(lblCdigoDoProduto);
		
		tfCodigoProduto = new JTextField();
		panel_4.add(tfCodigoProduto);
		tfCodigoProduto.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panel_4.add(btnAdicionar);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnRemover = new JButton("Remover");
		panel_5.add(btnRemover);
		
		JButton btnSalvar = new JButton("Salvar card\u00E1pio");
=======
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
>>>>>>> refs/remotes/origin/view
		panel_5.add(btnSalvar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
