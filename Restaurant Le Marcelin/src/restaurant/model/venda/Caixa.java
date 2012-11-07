package restaurant.model.venda;

import java.util.Date;
import java.util.HashSet;


public class Caixa {
	
	private int codigo;
	private Date dia;
	private float valor;
	private float valorInicial;
	private HashSet<Pagamento> pagamentos;
	
	public Caixa(float valorInicial) {		
		this.valorInicial = valorInicial;
		codigo = 0;
		dia = new Date();
		valor = 0;
	}
	
	public void suprimento(float valor){
		this.valor += valor;
	}
	
	public void sangria(float valor){
		this.valor -= valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(float valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	public void adicionaPagamento(Pagamento pagamento){
		pagamentos.add(pagamento);
	}
	
	public void removePagamento(Pagamento pagamento){
		pagamentos.remove(pagamento);
	}
	
	

}
