package Mahmoud_app.Controllers.Client;

import java.net.URL;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Book;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BookCellController implements Initializable{
	
	public Label book_name_lbl;
	public Label author_lbl;
	public Label amount_lbl;
	
	
	private final Book book;
	
	public BookCellController(Book book) {
		this.book=book;
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  book_name_lbl.textProperty().bind(book.bookNameProperty());
	        author_lbl.textProperty().bind(book.authorProperty());

	        // Use Bindings.createStringBinding to convert int to StringBinding
	        StringBinding amountBinding = Bindings.createStringBinding(() -> Integer.toString(book.getAmount()));
	        amount_lbl.textProperty().bind(amountBinding);
	}

}
