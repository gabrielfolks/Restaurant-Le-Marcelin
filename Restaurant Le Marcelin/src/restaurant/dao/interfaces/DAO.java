package restaurant.dao.interfaces;

public interface DAO<T> {

	void adicionar(T entity);
	void atualizar(T entity);
	void remover(T entity);
}
