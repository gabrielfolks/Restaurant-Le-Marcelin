package restaurant.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class CaixaView {

	private JFrame frmCaixa;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtTotal;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaixaView window = new CaixaView();
					window.frmCaixa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaixaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCaixa = new JFrame();
		frmCaixa.setTitle("Caixa");
		frmCaixa.setBounds(100, 100, 760, 468);
		frmCaixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCaixa.getContentPane().setLayout(null);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(10, 386, 724, 44);
		frmCaixa.getContentPane().add(panelBotoes);
		
		JButton btnAbrirCaixa = new JButton("Abrir Caixa");
		panelBotoes.add(btnAbrirCaixa);
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		panelBotoes.add(btnFecharCaixa);
		
		JButton btnSair = new JButton("Sair");
		panelBotoes.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 724, 323);
		frmCaixa.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1, 1, 722, 38);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnListarMovimentosDo = new JButton("Listar Movimentos do Dia");
		btnListarMovimentosDo.setBounds(272, 5, 177, 26);
		panel_2.add(btnListarMovimentosDo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1, 60, 722, 143);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Forma Pagamento", "Valor"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(149);
		table.getColumnModel().getColumn(1).setPreferredWidth(176);
		scrollPane_1.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1, 215, 251, 69);
		panel.add(panel_3);
		
		JRadioButton rbSuprimento = new JRadioButton("Suprimento");
		rbSuprimento.setSelected(true);
		buttonGroup.add(rbSuprimento);
		panel_3.add(rbSuprimento);
		
		JRadioButton rbSangria = new JRadioButton("Sangria");
		buttonGroup.add(rbSangria);
		panel_3.add(rbSangria);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_3.add(textField);
		
		JButton btnLancar = new JButton("Lan\u00E7ar");
		panel_3.add(btnLancar);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 9, 55, 16);
		frmCaixa.getContentPane().add(lblStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 0, 380, 29);
		frmCaixa.getContentPane().add(panel_1);		
		 
		JRadioButton rdbtnAberto = new JRadioButton("Aberto");
		buttonGroup_1.add(rdbtnAberto);
		panel_1.add(rdbtnAberto);
		
		JRadioButton rdbtnFechado = new JRadioButton("Fechado");
		buttonGroup_1.add(rdbtnFechado);
		panel_1.add(rdbtnFechado);	
		
		JLabel lblTotalDoDia = new JLabel("Total do dia:");
		panel_1.add(lblTotalDoDia);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		panel_1.add(txtTotal);
		txtTotal.setColumns(10);
	
	}
}
