import restaurant.view.franquia.LoginView;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LoginView login = new restaurant.boundary.LoginView();
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		

	}

}
