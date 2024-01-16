package Mahmoud_app.Controllers.Admin;


import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminAddBookController implements Initializable{
	public Button back_btn;
	public TextField name_field;
	public TextField Author_field;
	public TextField Amount_field;
	public Button add_btn;
	
	
		@Override
		public void initialize(URL url, ResourceBundle resourceBundle) {
			back_btn.setOnAction(e->onBack_button());
			add_btn.setOnAction(e->onAddOrUpdateBook_button());
		}

private void onBack_button()
{
	Stage stage =(Stage) back_btn.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
	Model.getInstance().getViewfactory().closeStage(stage);
	Model.getInstance().getViewfactory().showAdminWindow();
	
}	

private void onAddOrUpdateBook_button() {
    String bookName = name_field.getText();
    String authorName = Author_field.getText();
    String amountStr = Amount_field.getText();

    try {
        int amount = Integer.parseInt(amountStr);

        if (bookName.equals("") || authorName.equals("") || amountStr.equals("")) {
            Model.getInstance().showAlert("Insufficient information", "Please enter all the required book details");
        } else if (amount < 0) {
            Model.getInstance().showAlert("Amount error", "The amount should be positive");
        } else {
            Model.getInstance().evaluateClientAdminAddOrUpdateBook(bookName, authorName, amount);
        }
    } catch (NumberFormatException e) {
        Model.getInstance().showAlert("Invalid input", "Please enter a valid integer for the amount");
    }
}


}




