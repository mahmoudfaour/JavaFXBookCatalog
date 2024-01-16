package Mahmoud_app.Controllers.Admin;

import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminMenuController implements Initializable{
 
	public Button remove_client_btn;
	public Button add_client_btn;
	public Button view_clients_btn;
	public Button remove_book_btn;
	public Button add_book_btn;
	public Button view_books_btn;
	public Button logout_btn;
	

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		addListeners();
	}
private void addListeners() {
	
	add_client_btn.setOnAction(e->onAddClient());
	view_clients_btn.setOnAction(e->onShowClients());
	add_book_btn.setOnAction(e->onAddBook());
	remove_book_btn.setOnAction(e->onRemoveBook());
	view_books_btn.setOnAction(e->onShowBooks());
	logout_btn.setOnAction(e->onLogout());

}

private void onAddClient()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showAddClientWindow();
	
}
private void onShowClients()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showClientListWindow();
	
}

private void onAddBook()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showAddBookWindow();;
	
}
private void onRemoveBook()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showRemoveBookWindow();
}

private void onShowBooks()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showBooksListWindow();;
}

private void onLogout()
{
	Stage stage =(Stage) logout_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showLoginWindow();
	Model.getInstance().setClientLoginSuccessFlag(false);
}



}


