package Mahmoud_app.Controllers.Admin;


import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Book;
import Mahmoud_app.Models.Model;
import Mahmoud_app.Views.BookCellAdminFactory;
import Mahmoud_app.Views.BookCellFactory;
import Mahmoud_app.Views.ClientCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class BooksViewListController implements Initializable{
	public Button back_btn;
	public ListView<Book> Books_list;
	
	
		@Override
		public void initialize(URL url, ResourceBundle resourceBundle) {
			back_btn.setOnAction(e->onBack_button());
			initData();
			Books_list.setItems(Model.getInstance().getBooks());
			Books_list.setCellFactory(e->new BookCellAdminFactory());
		}

private void onBack_button()
{
	Stage stage =(Stage) back_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showAdminWindow();
	
}	

private void initData() {
	if(Model.getInstance().getBooks().isEmpty()) {
		//we check if it's empty beacuse if we reload the page again the data will be reloaded so if we have 7 clients it will be 14 then 21 in each time i reload 
		Model.getInstance().setBooks();
	}
}

}





