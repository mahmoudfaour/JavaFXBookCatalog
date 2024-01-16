package Mahmoud_app.Controllers.Client;


import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class About_usController implements Initializable{
	public Button back_button;
		@Override
		public void initialize(URL url, ResourceBundle resourceBundle) {
			back_button.setOnAction(e->onBack_button());
		}

private void onBack_button()
{
	Stage stage =(Stage) back_button.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showClientWindow();
	
}		

}


