package restaurant.view.reserva;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
import javax.swing.JCheckBox;

public class ReservaView extends JFrame implements ActionListener {

	private JTextField tfNumeroMesaCadastro;
	private JTextField tfZona;
	private JTable table;
	private JButton btnSalvarMesa;
	private JButton btnExcluirMesa;
	private JButton btnBuscarMesa;
	private JButton btnListar;
	private JButton btnSalvarReserva;
	private JButton btnCancelarReserva;
	private ReservaTableModel reservaTableModel;
	private JFormattedTextField tfCPF;
	private JTextField tfNumeroMesaReserva;
	private MesaController mesaController;
	private ReservaController reservaController;
	private JSpinner spLugares;
	private JCheckBox cbFumante;
	private JButton btnAlterarMesa;
	private JSpinner spDataReserva;
	private JSpinner spDataConsulta;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaView window = new ReservaView();
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
	public ReservaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Restaurant Le Marcelin - Reservas");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane);
		
		JPanel abaReservar = new JPanel();
		abaReservar.setBackground(Color.WHITE);
		tabbedPane.addTab("Reservar", null, abaReservar, null);
		abaReservar.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setEnabled(false);
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCpf.setBounds(12, 11, 44, 16);
		abaReservar.add(lblCpf);
		
		JLabel lblDatahora = new JLabel("Data/Hora");
		lblDatahora.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDatahora.setBounds(10, 82, 84, 16);
		abaReservar.add(lblDatahora);
		
		btnSalvarReserva = new JButton("Salvar reserva");
		btnSalvarReserva.setBounds(84, 130, 140, 26);
		btnSalvarReserva.addActionListener(this);
		abaReservar.add(btnSalvarReserva);
		
		tfCPF = new JFormattedTextField(MascarasCampos.getCPFMask());
		tfCPF.setBackground(Color.WHITE);
		tfCPF.setBounds(84, 11, 129, 20);
		abaReservar.add(tfCPF);
		tfCPF.setColumns(10);
		
		JLabel lblNMesa = new JLabel("N\u00BA Mesa");
		lblNMesa.setBounds(12, 45, 46, 14);
		abaReservar.add(lblNMesa);
		
		tfNumeroMesaReserva = new JTextField();
		tfNumeroMesaReserva.setBackground(Color.WHITE);
		tfNumeroMesaReserva.setBounds(84, 42, 86, 20);
		abaReservar.add(tfNumeroMesaReserva);
		tfNumeroMesaReserva.setColumns(10);
		
		spDataReserva = new JSpinner();
		spDataReserva.setModel(new SpinnerDateModel(new Date(1355450400000L), new Date(1355450400000L), null, Calendar.DAY_OF_YEAR));
		spDataReserva.setBounds(94, 82, 119, 20);
		abaReservar.add(spDataReserva);
		
		JPanel abaConsultarReservas = new JPanel();
		abaConsultarReservas.setBackground(Color.WHITE);
		tabbedPane.addTab("Verificar Reservas", null, abaConsultarReservas, null);
		abaConsultarReservas.setLayout(null);
		
		JLabel label = new JLabel("Data/Hora");
		label.setBounds(12, 7, 70, 20);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		abaConsultarReservas.add(label);
		
			
		btnListar = new JButton("Listar");
		btnListar.setBounds(12, 42, 98, 26);
		btnListar.addActionListener(this);
		abaConsultarReservas.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 80, 679, 209);
		abaConsultarReservas.add(scrollPane);
		
		reservaTableModel = new ReservaTableModel();
		table = new JTable(reservaTableModel);
		scrollPane.setViewportView(table);
		
		btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.setBounds(160, 42, 179, 25);
		btnCancelarReserva.addActionListener(this);
		abaConsultarReservas.add(btnCancelarReserva);
		
		spDataConsulta = new JSpinner();
		spDataConsulta.setModel(new SpinnerDateModel(new Date(1355450400000L), new Date(1355450400000L), null, Calendar.DAY_OF_YEAR));
		spDataConsulta.setBounds(118, 9, 154, 20);
		abaConsultarReservas.add(spDataConsulta);
		
		JPanel abaMesas = new JPanel();
		abaMesas.setBackground(Color.WHITE);
		tabbedPane.addTab("Mesas", null, abaMesas, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		abaMesas.setLayout(null);
		
		JLabel lblId = new JLabel("N\u00FAmero");
		lblId.setFont(new Font("Dialog", Font.BOLD, 15));
		lblId.setBounds(22, 26, 107, 16);
		abaMesas.add(lblId);
		
		JLabel lblLugares = new JLabel("Lugares");
		lblLugares.setFont(new Font("Dialog", Font.BOLD, 15));
		lblLugares.setBounds(22, 54, 68, 16);
		abaMesas.add(lblLugares);
		
		JLabel lblFumante = new JLabel("Fumante");
		lblFumante.setFont(new Font("Dialog", Font.BOLD, 15));
		lblFumante.setBounds(22, 86, 68, 16);
		abaMesas.add(lblFumante);
		
		JLabel lblZona = new JLabel("Zona");
		lblZona.setFont(new Font("Dialog", Font.BOLD, 15));
		lblZona.setBounds(22, 118, 107, 16);
		abaMesas.add(lblZona);
		
		tfNumeroMesaCadastro = new JTextField();
		tfNumeroMesaCadastro.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfNumeroMesaCadastro.setBounds(96, 24, 43, 24);
		abaMesas.add(tfNumeroMesaCadastro);
		tfNumeroMesaCadastro.setColumns(10);
		
		tfZona = new JTextField();
		tfZona.setFont(new Font("Dialog", Font.PLAIN, 15));
		tfZona.setColumns(10);
		tfZona.setBounds(96, 114, 159, 24);
		abaMesas.add(tfZona);
		
		spLugares = new JSpinner();
		spLugares.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spLugares.setFont(new Font("Dialog", Font.PLAIN, 15));
		spLugares.setBounds(96, 54, 43, 20);
		abaMesas.add(spLugares);
		
		btnBuscarMesa = new JButton("Buscar");
		btnBuscarMesa.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBuscarMesa.setBounds(177, 22, 121, 26);
		btnBuscarMesa.addActionListener(this);
		abaMesas.add(btnBuscarMesa);
		
		btnSalvarMesa = new JButton("Cadastrar");
		btnSalvarMesa.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSalvarMesa.setBounds(12, 160, 98, 26);
		btnSalvarMesa.addActionListener(this);
		abaMesas.add(btnSalvarMesa);
		
		btnExcluirMesa = new JButton("Excluir");
		btnExcluirMesa.setEnabled(false);
		btnExcluirMesa.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnExcluirMesa.setBounds(227, 160, 98, 26);
		btnExcluirMesa.addActionListener(this);
		abaMesas.add(btnExcluirMesa);
		
		cbFumante = new JCheckBox("");
		cbFumante.setBounds(96, 86, 21, 23);
		abaMesas.add(cbFumante);
		
		btnAlterarMesa = new JButton("Alterar");
		btnAlterarMesa.setEnabled(false);
		btnAlterarMesa.setBounds(120, 164, 89, 24);
		btnAlterarMesa.addActionListener(this);
		abaMesas.add(btnAlterarMesa);
		
		mesaController = new MesaController();
		reservaController = new ReservaController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Reserva reserva;
		Mesa mesa;
		
	
		if (e.getSource() == btnSalvarReserva) {
			reserva = new Reserva();
			
			reserva.setCliente(pesquisarCliente());
			
			int numeroMesa = Integer.parseInt(tfNumeroMesaReserva.getText());
			
			reserva.setMesa(mesaController.pesquisarMesaPorNumero(numeroMesa));
			reserva.setData((Date) spDataReserva.getValue());
			
			System.out.println(spDataReserva.getValue());
			
			reservaController.adicionar(reserva);
						
		}
		
		else if (e.getSource() == btnListar) {
			reservaTableModel.limpar();
			
			reserva = reservaController.procurarPorData((Date) spDataConsulta.getValue());
				
				if (reserva == null) {
					JOptionPane.showMessageDialog(null, "Nenhuma reserva encontrada!");
				} else {
					reservaTableModel.adicionarReserva(reserva); 
				}
		}
		
		else if (e.getSource() == btnCancelarReserva) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Nenhuma reserva foi selecionada");
			} else {
				reservaController.remover(reservaTableModel.getReserva(table.getSelectedRow()));
				JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso!", 
						"Reservas", JOptionPane.INFORMATION_MESSAGE);
				reservaTableModel.limpar();
			}
			
		} else if (e.getSource() == btnSalvarMesa) {
			mesa = criarMesa();
			
			mesaController.adicionarMesa(mesa);
			
			limparCamposMesa();
		} else if (e.getSource() == btnBuscarMesa) {
			mesa = pesquisarMesa();
			
			if (mesa == null) {
				JOptionPane.showMessageDialog(null, "Mesa não encontrada");
			} else {
				tfNumeroMesaCadastro.setText(Integer.toString(mesa.getNumero()));
				spLugares.setValue(mesa.getLugares());
				cbFumante.setSelected(mesa.isFumante());
				tfZona.setText(mesa.getZona());
			
				btnAlterarMesa.setEnabled(true);
				btnExcluirMesa.setEnabled(true);
			}
		} else if (e.getSource() == btnAlterarMesa) {
			mesa = criarMesa();
			
			mesaController.atualizarMesa(mesa);
			
			limparCamposMesa();
			
		} else if (e.getSource() == btnExcluirMesa) {
			mesa = criarMesa();

			mesaController.removerMesa(mesa);
			
			limparCamposMesa();
		}
		
	}

	private Mesa pesquisarMesa() {
		int numeroMesa = Integer.parseInt(tfNumeroMesaCadastro.getText());
		Mesa mesa = mesaController.pesquisarMesaPorNumero(numeroMesa);

		return mesa;
		
	}

	private Cliente pesquisarCliente() {
		Cliente	cliente = new ClienteController().pesquisarPorCPF((String) tfCPF.getValue());
		
		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado");
		}
		
		return cliente;
	}
	
	private Mesa criarMesa() {
		Mesa mesa = new Mesa();
			
		mesa.setNumero(Integer.parseInt(tfNumeroMesaCadastro.getText()));
		
		mesa.setLugares((int)spLugares.getValue());
		mesa.setFumante(cbFumante.isSelected());
		mesa.setZona(tfZona.getText());
		
		btnAlterarMesa.setEnabled(false);
		btnExcluirMesa.setEnabled(false);
					
		return mesa;
	}
	
	private void limparCamposMesa() {
		tfNumeroMesaCadastro.setText("");
		spLugares.setValue(0);
		cbFumante.setSelected(false);
		tfZona.setText("");
	}
}
