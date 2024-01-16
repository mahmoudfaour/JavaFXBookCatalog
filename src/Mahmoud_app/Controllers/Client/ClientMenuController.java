package Mahmoud_app.Controllers.Client;


import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ClientMenuController implements Initializable{
	
	public Button dashboard_btn;
	public Button store_btn;
	public Button about_btn;
	public Button profile_btn;
	public Button logout_btn;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		addListeners();
	}
private void addListeners() {
	
	about_btn.setOnAction(e->onAbout_us());
	profile_btn.setOnAction(e->onProfile());
	logout_btn.setOnAction(e->onLogout());
}	



private void onAbout_us()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showAbout_usView();
	
}
private void onProfile()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showProfileWindow();;
	
}

private void onLogout()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showLoginWindow();
	Model.getInstance().setClientLoginSuccessFlag(false);
}
}

