package Mahmoud_app.Controllers.Admin;
import Mahmoud_app.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminAddClientController implements Initializable{
	public Button back_btn;
	public TextField name_field;
	public TextField pass_field;
	public Button add_btn;
	
	
	
	
		@Override
		public void initialize(URL url, ResourceBundle resourceBundle) {
			back_btn.setOnAction(e->onBack_button());
			add_btn.setOnAction(e->onAdd_button());
		}

private void onBack_button()
{
	Stage stage =(Stage) back_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showAdminWindow();
	
}	
private void onAdd_button() {
    String nm = name_field.getText();
    String pss = pass_field.getText();

    if (nm.equals("") || pss.equals("")) {
        Model.getInstance().showAlert("Insufficient information", "Please enter all the required info");
    } else {
        Model.getInstance().evaluateClientAdminAdd(nm, pss);
    }
}

	
}








