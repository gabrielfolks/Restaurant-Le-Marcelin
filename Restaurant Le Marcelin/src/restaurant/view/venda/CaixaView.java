package restaurant.view.venda;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CaixaView extends JFrame implements ActionListener {

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
	public CaixaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Caixa");
		this.setBounds(100, 100, 760, 468);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(10, 386, 724, 44);
		this.getContentPane().add(panelBotoes);
		
		JButton btnAbrirCaixa = new JButton("Abrir Caixa");
		panelBotoes.add(btnAbrirCaixa);
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		panelBotoes.add(btnFecharCaixa);
		
		JButton btnSair = new JButton("Sair");
		panelBotoes.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 724, 323);
		this.getContentPane().add(panel);
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
		this.getContentPane().add(lblStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 0, 380, 29);
		this.getContentPane().add(panel_1);		
		 
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
