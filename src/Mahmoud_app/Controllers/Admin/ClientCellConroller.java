package Mahmoud_app.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ClientCellConroller implements Initializable {
  public Label client_name_lbl;
  public Label pass_lbl;
	

  private final Client client;
  
  public ClientCellConroller(Client client) {
	  this.client= client;
	  
  }
  
  
  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		client_name_lbl.textProperty().bind(client.nameProperty());
		pass_lbl.textProperty().bind(client.passwordProperty());
	}

}
