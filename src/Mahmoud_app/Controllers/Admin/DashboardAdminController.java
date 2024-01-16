package Mahmoud_app.Controllers.Admin;
import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DashboardAdminController implements Initializable{
	
	public Text user_name;
	public Label login_date;
	public TextField client_name_field;
	public Button remove_btn;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		remove_btn.setOnAction(e->onDelete_button());
	}
	
	private void onDelete_button() {
	    String nm = client_name_field.getText();

	    if (nm.equals("")) {
	        Model.getInstance().showAlert("Insufficient information", "Please enter the client name to delete");
	    } else {
	        Model.getInstance().evaluateClientAdminDelete(nm);
	    }
	}


}
