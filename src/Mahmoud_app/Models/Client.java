package Mahmoud_app.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	
	private final StringProperty client_name;
	private final StringProperty password;
	
	
	public Client(String client_name, String Password) {
		this.client_name = new SimpleStringProperty(this, "client_name" ,client_name);
		this.password = new SimpleStringProperty(this, "password" ,Password);
		
		
	}
	public StringProperty nameProperty() {
		return this.client_name;
	} 
	
	public StringProperty passwordProperty() {
		return this.password;
	} 
	

}
