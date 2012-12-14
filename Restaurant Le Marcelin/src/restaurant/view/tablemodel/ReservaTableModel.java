package restaurant.view.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import restaurant.model.reserva.Reserva;

public class ReservaTableModel extends AbstractTableModel {

	private List<Reserva> linhas;
	private String[] colunas = {"ID", "Cliente", "Nº Mesa", "Data/Hora"};

	private static final int ID = 0;
	private static final int CLIENTE = 1;
	private static final int NMESA = 2;
	private static final int DATAHORA = 3;
	
	public ReservaTableModel() {
		linhas = new ArrayList<>();
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		Reserva reserva = linhas.get(rowIndex);
		
		switch (rowIndex) {
			case ID:
				return reserva.getId();
			case CLIENTE:
				return reserva.getCliente().getNome();
			case NMESA:
				return reserva.getMesa().getNumero();
			case DATAHORA:
				return reserva.getData();
		}
		
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public Reserva getReserva(int rowIndex) {
		return linhas.get(rowIndex);
	}
	
	public void adicionarReserva(Reserva reserva) {
		linhas.add(reserva);
		
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void adicionarListaDeReserva(List<Reserva> reservas) {
		int indice = getRowCount();
		
		linhas.addAll(reservas);
		fireTableRowsInserted(indice, indice + reservas.size());
	}
	
	public void removerReserva(int indiceLinha) {
		linhas.remove(indiceLinha);
		
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	public void limpar() {
		linhas.clear();
		
		fireTableDataChanged();
	}

}
