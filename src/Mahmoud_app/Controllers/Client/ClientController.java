package Mahmoud_app.Controllers.Client;

import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class ClientController implements Initializable{
	
	public BorderPane client_parent;
	
	 @Override
 	public void initialize(URL url, ResourceBundle resourceBundle) {
		 
		/* Model.getInstance().getViewfactory().clientSlectedMenuItem().addListener((observableValue, oldVal, newVal)->
		 
		 {
			 switch(newVal) {
			case "About Us" ->client_parent.setCenter(Model.getInstance().getViewfactory().getAbout_usView());
			default ->client_parent.setCenter(Model.getInstance().getViewfactory().getDashboardView());
			 }
		 }
				 );
	 }*/
		 
}}
