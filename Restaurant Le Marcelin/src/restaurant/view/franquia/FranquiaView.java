package restaurant.view.franquia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import restaurant.control.franquia.FranquiaController;
import restaurant.model.franquia.Franquia;
import restaurant.util.MascarasCampos;

public class FranquiaView extends JFrame implements ActionListener {

	private JTextField tfRazao;
	private JTextField tfFantasia;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	private JFormattedTextField tfCEP;
	private JLabel lblCnpj;
	private JFormattedTextField tfCNPJ;
	private JButton btnSalvar;
	private JComboBox<String> cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FranquiaView window = new FranquiaView();
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
	public FranquiaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Restaurant Le Marcelin - Franquia");
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(null);
		
		JLabel lblRazao = new JLabel("Raz\u00E3o Social");
		lblRazao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRazao.setBounds(12, 13, 98, 16);
		this.getContentPane().add(lblRazao);
		
		tfRazao = new JTextField();
		tfRazao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfRazao.setBounds(106, 10, 403, 22);
		this.getContentPane().add(tfRazao);
		tfRazao.setColumns(10);
		
		JLabel lblFantasia = new JLabel("Fantasia");
		lblFantasia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblFantasia.setBounds(12, 43, 98, 16);
		this.getContentPane().add(lblFantasia);
		
		tfFantasia = new JTextField();
		tfFantasia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfFantasia.setColumns(10);
		tfFantasia.setBounds(106, 40, 403, 22);
		this.getContentPane().add(tfFantasia);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEndereo.setBounds(12, 105, 98, 16);
		this.getContentPane().add(lblEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(106, 102, 403, 22);
		this.getContentPane().add(tfEndereco);
		
		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCidade.setColumns(10);
		tfCidade.setBounds(106, 134, 403, 22);
		this.getContentPane().add(tfCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCidade.setBounds(12, 137, 98, 16);
		this.getContentPane().add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEstado.setBounds(12, 171, 98, 16);
		this.getContentPane().add(lblEstado);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCep.setBounds(12, 206, 98, 16);
		this.getContentPane().add(lblCep);
		
		
		tfCEP = new JFormattedTextField(MascarasCampos.getCEPMask());
		tfCEP.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCEP.setColumns(10);
		tfCEP.setBounds(106, 203, 109, 22);
		this.getContentPane().add(tfCEP);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBounds(239, 204, 95, 25);
		this.getContentPane().add(btnSalvar);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCnpj.setBounds(12, 74, 98, 16);
		this.getContentPane().add(lblCnpj);
		
		
		tfCNPJ = new JFormattedTextField(MascarasCampos.getCNPJMask());
		
		tfCNPJ.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(106, 71, 403, 22);
		
		this.getContentPane().add(tfCNPJ);
		
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
		
	}
	
	
}
