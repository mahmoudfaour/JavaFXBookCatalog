package Mahmoud_app.Models;

import com.mysql.cj.conf.IntegerProperty;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
	
	private final StringProperty book_name;
	private final StringProperty author;
	private final int amount;
	
	
	
	public Book(String book_name, String author,  int amount) {
		this.book_name = new SimpleStringProperty(this, "book_name" ,book_name);
		this.author = new SimpleStringProperty(this, "author" ,author);
		this.amount = amount;
		
		
	}
	public StringProperty bookNameProperty() {
		return this.book_name;
	} 
	
	public StringProperty authorProperty() {
		return this.author;
	} 
	
	public int getAmount() {
		return this.amount;
	} 
	
	

}
