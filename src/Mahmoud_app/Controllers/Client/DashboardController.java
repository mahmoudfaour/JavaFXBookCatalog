package Mahmoud_app.Controllers.Client;

import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import Mahmoud_app.Views.BookCellAdminFactory;
import Mahmoud_app.Views.BookCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController implements Initializable{
	
	public Text user_name;
	public Label login_date;
	public ListView book_listview;
	public TextField book_name;
	public TextField author;
	public TextField amount_field;
	public Button buy_btn;
	public Button reload_btn;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	buy_btn.setOnAction(e->onDeleteBook_button());
	initData();
	book_listview.setItems(Model.getInstance().getBooks());
	book_listview.setCellFactory(e->new BookCellFactory());
	reload_btn.setOnAction(e->onReloadButton());
	
		
	}
	
	
	private void onDeleteBook_button() {
	    String bookName = book_name.getText();
	    String authorName = author.getText();
	    String amountStr = amount_field.getText();

	    try {
	        int amount = Integer.parseInt(amountStr);

	        if (bookName.equals("") || authorName.equals("") || amountStr.equals("")) {
	            Model.getInstance().showAlert("Insufficient information", "Please enter all the required book details to purchase");
	        } else if (amount < 0) {
	            Model.getInstance().showAlert("Amount error", "The amount should be positive ");
	        } else {
	            Model.getInstance().evaluateClientBuyBook(bookName, authorName, amount);
	        }
	    } catch (NumberFormatException e) {
	        Model.getInstance().showAlert("Invalid input", "Please enter a valid integer for the amount");
	    }
	}
	
	
	private void initData() {
		if(Model.getInstance().getBooks().isEmpty()) {
			//we check if it's empty beacuse if we reload the page again the data will be reloaded so if we have 7 clients it will be 14 then 21 in each time i reload 
			Model.getInstance().setBooks();
		}
	}
	private void onReloadButton() {
		book_name.clear();
		author.clear();
		amount_field.clear();
		book_listview.getItems().clear(); 
	   // Stage stage = (Stage) reload_btn.getScene().getWindow();
	   // Model.getInstance().getViewfactory().closeStage(stage);
        //Model.getInstance().getViewfactory().showClientWindow();
	    initData();
	    book_listview.setItems(Model.getInstance().getBooks());
	    book_listview.setCellFactory(e -> new BookCellFactory());
	}


}
