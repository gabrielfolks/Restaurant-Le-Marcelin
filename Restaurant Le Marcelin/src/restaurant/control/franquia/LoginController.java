package restaurant.control.franquia;

import restaurant.dao.DAOFactory;
import restaurant.dao.interfaces.ILoginDAO;
import restaurant.model.franquia.Login;

public class LoginController {

	ILoginDAO loginDAO;
	
	public LoginController() {
		loginDAO = DAOFactory.createLoginDAO();
	}
	
	public void adicionarLogin(Login login) {
		loginDAO.adicionar(login);
	}
	
	public void removerLogin(Login login) {
		loginDAO.remover(login);
	}
	
	public void atualizarLogin(Login login) {
		loginDAO.atualizar(login);
	}
	
	public boolean verificarSenha(Login login) {
		return false;
	}

	public Login pesquisarUsuario(String nomeUsuario) {
		return loginDAO.pesquisarUsuario(nomeUsuario);
	}
	
}
