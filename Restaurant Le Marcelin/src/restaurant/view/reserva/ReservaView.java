package restaurant.view.reserva;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import restaurant.control.reserva.ClienteController;
import restaurant.control.reserva.MesaController;
import restaurant.control.reserva.ReservaController;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ReservaTableModel;
import javax.swing.JCheckBox;rt javax.swing.SpinnerDateModel;

import javax.swing.SpinnerNumberModel;

import restaurant.control.reserva.ClienteController;
import restaurant.control.reserva.MesaController;
import restaurant.control.reserva.ReservaController;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ReservaTableModel;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

import restaurant.control.reserva.ClienteController;
import restaurant.control.reserva.MesaController;
import restaurant.control.reserva.ReservaController;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ReservaTableModel;
import javax.swing.JCheckBox;avax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
		this.getContentPane().add(tfCNPJ);
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import restaurant.control.reserva.ClienteController;
import restaurant.control.reserva.MesaController;
import restaurant.control.reserva.ReservaController;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ReservaTableModel;
import javax.swing.JCheckBox;
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM ", "BA", "CE", "DF", "ES", "GO ", "MA", "MT", "MS", "MG", "PA ", "PB", "PR", "PE", "PI", "RJ", "RN ", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboEstado.setBounds(106, 172, 51, 20);
		this.getContentPane().add(cboEstado);
		this.setBounds(100, 100, 581, 295);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Franquia f = new Franquia();
		FranquiaController fc = new FranquiaController();
		
		if (arg0.getSource() == btnSalvar) {
			f.setRazao(tfRazao.getText());
			f.setFantasia(tfFantasia.getText());
			f.setEndereco(tfEndereco.getText());
			f.setCEP((String)tfCEP.getValue());
			f.setCnpj((String) tfCNPJ.getValue());
			f.setCidade(tfCidade.getText());
			f.setEstado((String)cboEstado.getSelectedItem());
			
			fc.adicionarFranquia(f);
		}
		
rt javax.swing.SpinnerDateModel;

import javax.swing.SpinnerNumberModel;

import restaurant.control.reserva.ClienteController;
import restaurant.control.reserva.MesaController;
import restaurant.control.reserva.ReservaController;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ReservaTableModel;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

import restaurant.control.reserva.ClienteController;
import restaurant.control.reserva.MesaController;
import restaurant.control.reserva.ReservaController;
import restaurant.model.reserva.Cliente;
import restaurant.model.reserva.Mesa;
import restaurant.model.reserva.Reserva;
import restaurant.util.MascarasCampos;
import restaurant.view.tablemodel.ReservaTableModel;
import javax.swing.JCheckBox;

public class ReservaView {

	private JFrame frmRestaurantLeMarcelin;
	private JTextField tfNumero;
	private JTextField tfZona;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaView window = new ReservaView();
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
	public ReservaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRestaurantLeMarcelin = new JFrame();
		frmRestaurantLeMarcelin.setTitle("Restaurant Le Marcelin - Reservas");
		frmRestaurantLeMarcelin.setBounds(100, 100, 800, 600);
		frmRestaurantLeMarcelin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRestaurantLeMarcelin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmRestaurantLeMarcelin.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Reservar", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId_1.setBounds(12, 14, 25, 16);
		panel.add(lblId_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(108, 10, 78, 24);
		panel.add(textField);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCliente.setBounds(12, 53, 84, 16);
		panel.add(lblCliente);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(108, 46, 78, 24);
		panel.add(textField_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setEnabled(false);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNome.setBounds(204, 53, 84, 16);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setEnabled(false);
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCpf.setBounds(383, 53, 84, 16);
		panel.add(lblCpf);
		
		JLabel lblDatahora = new JLabel("Data/Hora");
		lblDatahora.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDatahora.setBounds(12, 95, 84, 16);
		panel.add(lblDatahora);
		
		JSpinner spinData = new JSpinner();
		spinData.setModel(new SpinnerDateModel(new Date(1352944800000L), null, new Date(32535136800000L), Calendar.DAY_OF_YEAR));
		spinData.setFont(new Font("Dialog", Font.PLAIN, 15));
		spinData.setBounds(108, 93, 165, 20);
		panel.add(spinData);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setBounds(12, 138, 98, 26);
		panel.add(btnSalvar_1);
		
		JButton btnLimpar1 = new JButton("Limpar");
		btnLimpar1.setBounds(115, 138, 98, 26);
		panel.add(btnLimpar1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Verificar Reservas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Data/Hora");
		label.setBounds(12, 7, 70, 20);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_2.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1352944800000L), new Date(1352944800000L), new Date(32535136800000L), Calendar.DAY_OF_YEAR));
		spinner.setBounds(100, 5, 173, 24);
		spinner.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_2.add(spinner);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(12, 42, 98, 26);
		panel_2.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 80, 679, 209);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Cliente", "Mesa", "Data/Hora"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Mesas", null, panel_1, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("N\u00FAmero");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(22, 26, 107, 16);
		panel_1.add(lblId);
		
		JLabel lblLugares = new JLabel("Lugares");
		lblLugares.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLugares.setBounds(22, 54, 68, 16);
		panel_1.add(lblLugares);
		
		JLabel lblFumante = new JLabel("Fumante");
		lblFumante.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFumante.setBounds(22, 86, 68, 16);
		panel_1.add(lblFumante);
		
		JLabel lblZona = new JLabel("Zona");
		lblZona.setFont(new Font("Dialog", Font.BOLD, 15));
		lblZona.setBounds(22, 118, 107, 16);
		panel_1.add(lblZona);
		
		tfNumero = new JTextField();
		tfNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfNumero.setBounds(96, 24, 159, 24);
		panel_1.add(tfNumero);
		tfNumero.setColumns(10);
		
		tfZona = new JTextField();
		tfZona.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfZona.setColumns(10);
		tfZona.setBounds(96, 114, 159, 24);
		panel_1.add(tfZona);
		
		JSpinner spLugares = new JSpinner();
		spLugares.setModel(new SpinnerNumberModel(new Short((short) 0), new Short((short) 0), null, new Short((short) 1)));
		spLugares.setFont(new Font("Dialog", Font.PLAIN, 15));
		spLugares.setBounds(96, 54, 43, 20);
		panel_1.add(spLugares);
		
		JComboBox cbFumante = new JComboBox();
		cbFumante.setBackground(Color.WHITE);
		cbFumante.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o", "Sim"}));
		cbFumante.setFont(new Font("Dialog", Font.BOLD, 15));
		cbFumante.setBounds(96, 83, 68, 25);
		panel_1.add(cbFumante);
		
		JButton btnBuscar = new JButton("Buscar mesa");
		btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBuscar.setBounds(269, 22, 121, 26);
		panel_1.add(btnBuscar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSalvar.setBounds(12, 160, 98, 26);
		panel_1.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnExcluir.setBounds(122, 160, 98, 26);
		panel_1.add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLimpar.setBounds(232, 160, 98, 26);
		panel_1.add(btnLimpar);
	}
}
