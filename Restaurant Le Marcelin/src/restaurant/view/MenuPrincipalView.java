package restaurant.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import restaurant.view.estoque.FornecedorView;
import restaurant.view.estoque.ProdutoView;
import restaurant.view.franquia.CardapioView;
import restaurant.view.franquia.FuncionarioView;
import restaurant.view.franquia.LoginView;
import restaurant.view.reserva.ClienteView;
import restaurant.view.reserva.ReservaView;
import restaurant.view.venda.CaixaView;
import restaurant.view.venda.ComandaPedidoView;
import restaurant.view.venda.DeliveryView;

public class MenuPrincipalView extends JFrame implements ActionListener {

	private JMenuItem mntmManterClientes;
	private JPanel painelPrincipal;
	private JMenuItem mntmManterFuncionrios;
	private JMenuItem mntmManterFornecedores;
	private CardLayout layout;
	private JMenuItem mntmReservas;
	private JMenuItem mntmManterCardpio;
	private JMenu mnSair;
	private JMenuItem mntmEncerrarSesso;
	private JMenuItem mntmFechar;
	private JMenuItem mntmDelivery;
	private JMenuItem mntmComanda;
	private JMenuItem mntmManterProduto;
	private JMenuItem mntmCaixa;

	public MenuPrincipalView() {
		initialize();
	}

	public static void main(String[] args) {
		new MenuPrincipalView();
	}
	
	private void initialize() {
		this.setTitle("Administra\u00E7\u00E3o - Restaurant Le Marcelin");
		this.setBounds(100, 100, 952, 488);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnEstabelecimento = new JMenu("Estabelecimento");
		menuBar.add(mnEstabelecimento);
		
		mntmCaixa = new JMenuItem("Caixa");
		mntmCaixa.addActionListener(this);
		mnEstabelecimento.add(mntmCaixa);
		
		mntmComanda = new JMenuItem("Comanda");
		mntmComanda.addActionListener(this);
		mnEstabelecimento.add(mntmComanda);
		
		mntmDelivery = new JMenuItem("Delivery");
		mntmDelivery.addActionListener(this);
		mnEstabelecimento.add(mntmDelivery);
		
		mntmReservas = new JMenuItem("Reserva de mesas");
		mntmReservas.addActionListener(this);
		mnEstabelecimento.add(mntmReservas);
		
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);
		
		mntmManterProduto = new JMenuItem("Manter produto");
		mntmManterProduto.addActionListener(this);
		mnProduto.add(mntmManterProduto);
		
		mntmManterCardpio = new JMenuItem("Manter card\u00E1pio");
		mntmManterCardpio.addActionListener(this);
		mnProduto.add(mntmManterCardpio);
		
		JMenu mnRh = new JMenu("Recursos Humanos");
		menuBar.add(mnRh);
		
		mntmManterClientes = new JMenuItem("Clientes");
		mnRh.add(mntmManterClientes);
		mntmManterClientes.addActionListener(this);
		
		mntmManterFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mntmManterFuncionrios.addActionListener(this);
		mnRh.add(mntmManterFuncionrios);
		
		mntmManterFornecedores = new JMenuItem("Fornecedores");
		mnRh.add(mntmManterFornecedores);
		mntmManterFornecedores.addActionListener(this);
		
		mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		mntmEncerrarSesso = new JMenuItem("Encerrar sess\u00E3o");
		mntmEncerrarSesso.addActionListener(this);
		mnSair.add(mntmEncerrarSesso);
		
		mntmFechar = new JMenuItem("Fechar");
		mntmFechar.addActionListener(this);
		mnSair.add(mntmFechar);
		
		painelPrincipal = new JPanel();
		this.setContentPane(painelPrincipal);
		painelPrincipal.setLayout(new CardLayout(0, 0));
		setVisible(true);
		setLocationRelativeTo(null);
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmEncerrarSesso) {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Você deseja sair?");
			
			if (showConfirmDialog == 0) {
				this.dispose();
				LoginView lv = new LoginView();
				lv.setVisible(true);
			}
		} 
		
		else if (e.getSource() == mntmFechar) {
			int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Você deseja sair?");
			
			if (showConfirmDialog == 0) 
				System.exit(0);
		
		} 
		
		  else if (e.getSource() == mntmManterClientes) 
			colocarPainelNaTela(new ClienteView().getContentPane());
		  else if (e.getSource() == mntmManterFornecedores) 
			colocarPainelNaTela(new FornecedorView().getContentPane());
		  else if (e.getSource() == mntmManterFuncionrios) 
			colocarPainelNaTela(new FuncionarioView().getContentPane());
		  else if (e.getSource() == mntmComanda) 
			  colocarPainelNaTela(new ComandaPedidoView().getContentPane());
		  else if (e.getSource() == mntmCaixa)
			  colocarPainelNaTela(new CaixaView().getContentPane());
		  else if (e.getSource() == mntmDelivery)
			  colocarPainelNaTela(new DeliveryView().getContentPane());
		  else if (e.getSource() == mntmManterCardpio) 
			  colocarPainelNaTela(new CardapioView().getContentPane());
		  else if (e.getSource() == mntmReservas)
			  colocarPainelNaTela(new ReservaView().getContentPane());
		  else if (e.getSource() == mntmManterProduto)
			  colocarPainelNaTela(new ProdutoView().getContentPane());
		
	}

	private void colocarPainelNaTela(Container contentPane) {
		painelPrincipal.removeAll();
		
		contentPane.setSize(painelPrincipal.getSize());
		
		painelPrincipal.add(contentPane);
		painelPrincipal.repaint();
	}
}
