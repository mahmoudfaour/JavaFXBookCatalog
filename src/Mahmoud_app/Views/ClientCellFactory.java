package Mahmoud_app.Views;

import Mahmoud_app.Controllers.Admin.ClientCellConroller;
import Mahmoud_app.Models.Book;
import Mahmoud_app.Models.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ClientCellFactory extends ListCell<Client>{
	
	protected void updateItem(Client client , boolean empty) {
		
		super.updateItem(client, empty);
		if(empty) {
		setText(null);
		setGraphic(null);
		
		}else {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientCell.fxml"));
			ClientCellConroller controller = new ClientCellConroller(client);
			loader.setController(controller);
			setText(null);
			try {
				setGraphic(loader.load());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
