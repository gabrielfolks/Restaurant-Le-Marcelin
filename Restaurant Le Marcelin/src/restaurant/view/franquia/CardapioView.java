package restaurant.view.franquia;

import java.awt.EventQueue;
import java.awt.GridLayout;

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

public class CardapioView extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigoProduto;

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
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(BorderLayout.NORTH, panel_1);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da Semana");
		panel_1.add(lblDiaDaSemana);
		
		JComboBox cbDiaSemana = new JComboBox();
		panel_1.add(cbDiaSemana);
		cbDiaSemana.setModel(new DefaultComboBoxModel(DiaSemana.values()));
		
		JPanel panel_2 = new JPanel();
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
		panel_5.add(btnSalvar);
	}

}
