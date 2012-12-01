package restaurant.model.venda;

import java.util.Date;
import java.util.Set;


public class Caixa {
	
	private int id;
	private Date dia;
	private float valor;
	private float valorInicial;
	private Set<Pagamento> pagamentos;
	
	public Caixa(float valorInicial) {
		setValorInicial(valorInicial);
		id = 0;
		dia = new Date();
		valor = 0;
	}
	
	public void suprimento(float valor){
		this.valor += (valor > 0) ? valor : 0;
	}
	
	public void sangria(float valor){
		this.valor -= (valor > 0) ? valor : 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (id > 0) ? id : this.id;
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
		this.valor = (valor > 0) ? valor : this.valor;
	}

	public float getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(float valorInicial) {
		this.valorInicial = (valorInicial > 0) ? valorInicial : this.valorInicial;
	}
	
	public void adicionaPagamento(Pagamento pagamento){
		pagamentos.add(pagamento);
	}
	
	public void removePagamento(Pagamento pagamento){
		pagamentos.remove(pagamento);
	}
	
	

}
