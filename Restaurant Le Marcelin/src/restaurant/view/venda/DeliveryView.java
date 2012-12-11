package restaurant.view.venda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeliveryView extends JFrame {

	private JPanel contentPane;
	private JTextField tfCliente;
	private JTextField textField;
	private JTextField txtPrevisao;
	private JTextField textField_1;
	private JTextField txtPrevisaoentrega;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryView frame = new DeliveryView();
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
	public DeliveryView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Numero");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPreviso = new JLabel("Previs\u00E3o");
		panel.add(lblPreviso);
		
		txtPrevisao = new JTextField();
		panel.add(txtPrevisao);
		txtPrevisao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		panel.add(lblValor);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		panel.add(lblCliente);
		
		tfCliente = new JTextField();
		panel.add(tfCliente);
		tfCliente.setColumns(10);
		
		JLabel lblPrevisoEntrega = new JLabel("Previs\u00E3o Entrega");
		panel.add(lblPrevisoEntrega);
		
		txtPrevisaoentrega = new JTextField();
		panel.add(txtPrevisaoentrega);
		txtPrevisaoentrega.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panel.add(btnAdicionar);
	}

}
