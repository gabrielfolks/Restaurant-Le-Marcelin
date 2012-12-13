package restaurant.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import restaurant.view.estoque.FornecedorView;
import restaurant.view.reserva.ClienteView;

public class MenuPrincipalView extends JFrame implements ActionListener {

	private JMenuItem mntmManterClientes;
	private JPanel painelPrincipal;
	private JMenuItem mntmManterFuncionrios;
	private JMenuItem mntmManterFornecedores;
	private CardLayout layout;

	public MenuPrincipalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Administra\u00E7\u00E3o - Restaurant Le Marcelin");
		this.setBounds(100, 100, 952, 488);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnEstabelecimento = new JMenu("Estabelecimento");
		menuBar.add(mnEstabelecimento);
		
		JMenuItem mntmReservas = new JMenuItem("Reserva de mesas");
		mnEstabelecimento.add(mntmReservas);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		JMenuItem mntmManterCardpio = new JMenuItem("Manter card\u00E1pio");
		mnProduto.add(mntmManterCardpio);
		
		JMenu mnRh = new JMenu("Recursos Humanos");
		menuBar.add(mnRh);
		
		mntmManterClientes = new JMenuItem("Clientes");
		mnRh.add(mntmManterClientes);
		mntmManterClientes.addActionListener(this);
		
		mntmManterFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mnRh.add(mntmManterFuncionrios);
		
		mntmManterFornecedores = new JMenuItem("Fornecedores");
		mnRh.add(mntmManterFornecedores);
		mntmManterFornecedores.addActionListener(this);
		
		JMenu mnLogout = new JMenu("Logout...");
		menuBar.add(mnLogout);
		
		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(layout);
		
		this.setContentPane(painelPrincipal);
		setVisible(true);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmManterClientes) {
			Container painelCliente = new ClienteView().getContentPane();
			
			painelCliente.setSize(painelPrincipal.getSize());
					
			painelPrincipal.add("Cliente", painelCliente);
			layout.show(painelPrincipal, "Cliente");
			painelPrincipal.repaint();
		} else if (e.getSource() == mntmManterFornecedores) {
			Container painelFornecedores = new FornecedorView().getContentPane();
			
			painelFornecedores.setSize(painelPrincipal.getSize());
			
			painelPrincipal.add("Fornecedor", painelFornecedores);
			layout.show(painelPrincipal, "Fornecedor");
			painelPrincipal.repaint();
		}
		
	}
}
