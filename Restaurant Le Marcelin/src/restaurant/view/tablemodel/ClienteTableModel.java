package restaurant.view.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import restaurant.model.reserva.Cliente;

public class ClienteTableModel extends AbstractTableModel {

	private List<Cliente> linhas;
	private String[] colunas = {"ID", "Nome", "CPF", "Endere�o","Telefone"};
	
	private static final int ID = 0;
	private static final int NOME = 1;
	private static final int CPF = 2;
	private static final int ENDERECO = 3;
	private static final int TELEFONE = 4;
	
	public ClienteTableModel() {
		linhas = new ArrayList<>();
	}
	
	public ClienteTableModel(List<Cliente> listaClientes) {
		linhas = new ArrayList<>(listaClientes);
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return linhas.size();
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = linhas.get(rowIndex);
		
		switch(columnIndex) {
			case ID:
				return cliente.getId();
			case NOME:
				return cliente.getNome();
			case CPF:
				return cliente.getCpf();
			case ENDERECO:
				return cliente.getEndereco();
			case TELEFONE:
				return cliente.getTelefone();
		}
		return null;
	}
	
	public Cliente getCliente(int indiceLinha) {
		return linhas.get(indiceLinha);
	}
	
	public void adicionarCliente(Cliente cliente) {
		linhas.add(cliente);
		
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void removerSocio(int indiceLinha) {
		linhas.remove(indiceLinha);
		
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	public void adicionarListaDeClientes(List<Cliente> clientes) {
		int indice = getRowCount();
		
		linhas.addAll(clientes);
		fireTableRowsInserted(indice, indice + clientes.size()); 
	}

	
	public void limpar() {
		linhas.clear();
		
		fireTableDataChanged();
	}
}
