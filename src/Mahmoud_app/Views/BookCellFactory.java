package Mahmoud_app.Views;

import Mahmoud_app.Controllers.Client.BookCellController;
import Mahmoud_app.Models.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class BookCellFactory extends ListCell<Book>{
	
	protected void updateItem(Book book , boolean empty) {
		
		super.updateItem(book, empty);
		if(empty) {
		setText(null);
		setGraphic(null);
		
		}else {
			FXMLLoader loader =new FXMLLoader(getClass().getResource("BookCell.fxml"));
			BookCellController controller = new BookCellController(book);
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
