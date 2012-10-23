package restaurant.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class MenuPrincipalView implements ActionListener {

	private JFrame frmAdministraoRestaurant;
	private JMenu mnCardapio;
	private JMenu mnPratos;
	private JMenu mnProdutos;
	private JMenu mnFornecedores;
	private JMenu mnFuncionarios;
	private JMenu mnClientes;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalView window = new MenuPrincipalView();
					window.frmAdministraoRestaurant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdministraoRestaurant = new JFrame();
		frmAdministraoRestaurant.setTitle("Administra\u00E7\u00E3o - Restaurant Le Marcelin");
		frmAdministraoRestaurant.setBounds(100, 100, 952, 488);
		frmAdministraoRestaurant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAdministraoRestaurant.setJMenuBar(menuBar);
		
		mnCardapio = new JMenu("Cardapio");
		mnCardapio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mnCardapio_actionPerformed(e);
			}
		});
		menuBar.add(mnCardapio);
		
		mnPratos = new JMenu("Pratos");
		menuBar.add(mnPratos);
		
		mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		mnFornecedores = new JMenu("Fornecedores");
		menuBar.add(mnFornecedores);
		
		mnFuncionarios = new JMenu("Funcion\u00E1rios");
		menuBar.add(mnFuncionarios);
		
		mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		frmAdministraoRestaurant.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		
		desktopPane = new JDesktopPane();
		frmAdministraoRestaurant.getContentPane().add(desktopPane);
	}	
	protected static void do_mnCardapio_actionPerformed(ActionEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnCardapio){
			
			JFrame cpv = new ComandaPedidoView().getFrmComandaRestaurant();
			cpv.setVisible(true);
			cpv.setSize(this.desktopPane.getSize());
			this.desktopPane.add(cpv);
			
		}
		
	}
}
