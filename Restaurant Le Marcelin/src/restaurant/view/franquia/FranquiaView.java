package restaurant.view.franquia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class FranquiaView {

	private JFrame frmRestaurantLeMarcelin;
	private JTextField tfRazao;
	private JTextField tfFantasia;
	private JTextField tfEndereco;
	private JTextField tfCidade;
	private JTextField tfEstado;
	private JFormattedTextField tfCEP;
	private JLabel lblCnpj;
	private JTextField tfCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FranquiaView window = new FranquiaView();
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
	public FranquiaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRestaurantLeMarcelin = new JFrame();
		frmRestaurantLeMarcelin.setTitle("Restaurant Le Marcelin - Franquia");
		frmRestaurantLeMarcelin.getContentPane().setBackground(Color.WHITE);
		frmRestaurantLeMarcelin.getContentPane().setLayout(null);
		
		JLabel lblRazao = new JLabel("Raz\u00E3o Social");
		lblRazao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblRazao.setBounds(12, 13, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblRazao);
		
		tfRazao = new JTextField();
		tfRazao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfRazao.setBounds(106, 10, 403, 22);
		frmRestaurantLeMarcelin.getContentPane().add(tfRazao);
		tfRazao.setColumns(10);
		
		JLabel lblFantasia = new JLabel("Fantasia");
		lblFantasia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblFantasia.setBounds(12, 43, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblFantasia);
		
		tfFantasia = new JTextField();
		tfFantasia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfFantasia.setColumns(10);
		tfFantasia.setBounds(106, 40, 403, 22);
		frmRestaurantLeMarcelin.getContentPane().add(tfFantasia);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEndereo.setBounds(12, 105, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblEndereo);
		
		tfEndereco = new JTextField();
		tfEndereco.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(106, 102, 403, 22);
		frmRestaurantLeMarcelin.getContentPane().add(tfEndereco);
		
		tfCidade = new JTextField();
		tfCidade.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCidade.setColumns(10);
		tfCidade.setBounds(106, 134, 403, 22);
		frmRestaurantLeMarcelin.getContentPane().add(tfCidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCidade.setBounds(12, 137, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblCidade);
		
		tfEstado = new JTextField();
		tfEstado.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfEstado.setColumns(10);
		tfEstado.setBounds(106, 168, 60, 22);
		frmRestaurantLeMarcelin.getContentPane().add(tfEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblEstado.setBounds(12, 171, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblEstado);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCep.setBounds(12, 206, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblCep);
		
		try {
			tfCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfCEP.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCEP.setColumns(10);
		tfCEP.setBounds(106, 203, 109, 22);
		frmRestaurantLeMarcelin.getContentPane().add(tfCEP);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(239, 204, 95, 25);
		frmRestaurantLeMarcelin.getContentPane().add(btnSalvar);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblCnpj.setBounds(12, 74, 98, 16);
		frmRestaurantLeMarcelin.getContentPane().add(lblCnpj);
		
		try {
			tfCNPJ = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfCNPJ.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tfCNPJ.setColumns(10);
		tfCNPJ.setBounds(106, 71, 403, 22);
		
		frmRestaurantLeMarcelin.getContentPane().add(tfCNPJ);
		frmRestaurantLeMarcelin.setBounds(100, 100, 581, 295);
		frmRestaurantLeMarcelin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
