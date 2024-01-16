package Mahmoud_app.Views;

import Mahmoud_app.Controllers.Admin.AdminController;
import Mahmoud_app.Controllers.Client.About_usController;
import Mahmoud_app.Controllers.Client.ClientController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
	
	
	private AccountType loginAccountType;
	
	private AnchorPane Login_view;
	
	//Client Views
	private AnchorPane dashboardView;
	private AnchorPane about_usview;
	
	//ADMIN VIEWS
	private AnchorPane AddClientView;
	
	
	//to check if the dashboard exict 
	public AnchorPane getDashboardView() {
		//we check if the dashboard is null because if the user go from the login to dashboard so no need to load it again
		if(dashboardView == null) {
			try {
				dashboardView = new FXMLLoader(getClass().getResource("Dashboard.fxml")).load();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dashboardView; // Don't forget to return the loaded AnchorPane
	}
	
	
	///constructor
	public ViewFactory() {
		this.loginAccountType = AccountType.CLIENT;
		
	}
	

	
	public AccountType getLoginAccountType() {
		return loginAccountType;
	}




	public void setLoginAccountType(AccountType loginAccountType) {
		this.loginAccountType = loginAccountType;
	}

	
	
	
	///////////////Clients Windows//////////////////s
	



	//to show the login window
	public void showLoginWindow() {
		FXMLLoader loader =new FXMLLoader(getClass().getResource("Login.fxml"));
		createStage(loader);
;	}
	
	
	//to show the client window heda nli zedna 3le l dashboard wel menu taba3 l client 
	public void showClientWindow() {
		FXMLLoader loader =new FXMLLoader(getClass().getResource("Client.fxml"));
		ClientController clientController =new ClientController();
		loader.setController(clientController);
		createStage(loader);
;	}
	
	
	//to show the about_us window 
	public void showAbout_usView() {
		FXMLLoader loader =new FXMLLoader(getClass().getResource("About_us.fxml"));
		createStage(loader);
;	}
	
	
	//to show the profile window 
		public void showProfileWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("Profile.fxml"));
			createStage(loader);
	;	}
		
		
		//////////////Admin Windows/////////////////// 
		
		//to show admin window li zedna 3le kel chi w hek 
		
		public void showAdminWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("Admin.fxml"));
			AdminController adminController =new AdminController();
			loader.setController(adminController);
			createStage(loader);
	;	}
		
		
		
		//display the add client window
		public void showAddClientWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("AdminAddClient.fxml"));
			createStage(loader);
	;	}
		
		//display the clients List 
		public void showClientListWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientList.fxml"));
			createStage(loader);
	;	}
		
		//display the add book window 
		
		public void showAddBookWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("AddBook.fxml"));
			createStage(loader);
	;	}
		
	//display the remove book window 
		
		public void showRemoveBookWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("RemoveBook.fxml"));
			createStage(loader);
	;	}
		
		// display the Books list window 
		
		
		public void showBooksListWindow() {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("BooksList.fxml"));
			createStage(loader);
	;	}
		
		
		
		
		
		
		
		
	
	//hayde l main fonction kermel ta3mel l page load w tbayen ta3mel launch lal stage s
	private void createStage(FXMLLoader loader) {
	    Scene scene = null;
	    try {
	        scene = new Scene(loader.load());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Stage stage = new Stage();
	    stage.setScene(scene);
	    stage.setTitle("Faour Book Store");
	    stage.show();
	}
	
	
	//hayde kermel tsaker l window l adim bas eftah wahad jdid 
	public void closeStage(Stage stage) {
		stage.close();
	}

	
}
