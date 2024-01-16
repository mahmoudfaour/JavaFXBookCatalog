package Mahmoud_app.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import Mahmoud_app.Views.AccountType;
import Mahmoud_app.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class Model {
	
	private static Model model;
	private final ViewFactory viewfactory;
	private final DatabaseDriver databaseDriver;
	private AccountType loginAccountType=AccountType.CLIENT;//hatayna hek la2en he awal value 3enna yeha 
	//Client Data Section
	private Client client;
	private boolean clientLoginSuccessFlag;//how we successfully verified the login credentials 
	private boolean adminLoginSuccessFlag;
	private Book book;
	
	
	private final ObservableList<Book> books;
	private final ObservableList<Client> clients;
	
	//Admin Data Section
	
	
	
	private Model() {
		
		this.viewfactory = new ViewFactory();
		this.databaseDriver= new DatabaseDriver();
		//Client Data
		
		this.clientLoginSuccessFlag=false;
		this.client=new Client("", "");
		this.adminLoginSuccessFlag=false;
		this.books = FXCollections.observableArrayList();
		this.clients = FXCollections.observableArrayList();
		
		
	}
	// this method is used to see if the object is not created yet 
	public static synchronized Model getInstance() {
		
		if (model==null) {
			model= new Model();
			
		}
		return model;
		
	}
	public ViewFactory getViewfactory() {
		return viewfactory;
	}
	public DatabaseDriver getDatabaseDriver() {
		return databaseDriver;
	}
	public AccountType getLoginAccountType() {
		return loginAccountType;
	}
	public void setLoginAccountType(AccountType loginAccountType) {
		this.loginAccountType = loginAccountType;
	}
	
	
	
	
	/*
	 * Client Method Section
	 * */
	public boolean getClientLoginSuccessFlag() {return this.clientLoginSuccessFlag;}
	public void setClientLoginSuccessFlag(boolean flag) {this.clientLoginSuccessFlag=flag;}
	
	public Client getClient() {
		return client ;
	}
	public Book getBook() {
		return book;
	}
	
	
	public boolean evaluateClientCred(String name, String password) {
	    try {
	        ResultSet resultSet = databaseDriver.getClientData(name, password);

	        if (resultSet != null && resultSet.next()) {
	            // Assuming that "client_name" and "pass" are column names in the result set
	            this.client.nameProperty().set(resultSet.getString("client_name"));
	            this.client.passwordProperty().set(resultSet.getString("pass"));
	            
	            this.clientLoginSuccessFlag = true; // Login successful
	            return true;
	        } else {
	            // No rows in the result set, handle the case accordingly
	            this.clientLoginSuccessFlag = false; // Login unsuccessful
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the exception for debugging
	        return false; // Return false in case of an exception
	    }
	}
	public boolean evaluateAdminCred(String name, String password) {
	    try {
	        ResultSet resultSet = databaseDriver.getAdminData(name, password);

	        if (resultSet != null && resultSet.next()) {
	            // Assuming that "client_name" and "pass" are column names in the result set
	            this.client.nameProperty().set(resultSet.getString("admin_name"));
	            this.client.passwordProperty().set(resultSet.getString("pass"));
	            
	            this.adminLoginSuccessFlag = true; // Login successful
	            return true;
	        } else {
	            // No rows in the result set, handle the case accordingly
	            this.adminLoginSuccessFlag = false; // Login unsuccessful
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Log the exception for debugging
	        return false; // Return false in case of an exception
	    }
	}
	
	public void evaluateClientAdminAdd(String name, String pass) {
	   try {
		   ResultSet resultSet = databaseDriver.insertNewClient(name, pass);
		   if(resultSet==null) {
			   
			   showAlert("Error ","Client not added ");
			   
		   }
		   else
			   showAlert("Success ","Client added successfuly");
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	     
	}

	public void evaluateClientAdminDelete(String name) {
	    try {
	        ResultSet resultSet = databaseDriver.deleteClient(name);
	        if (resultSet == null) {
	            showAlert("Error", "Client not deleted or No such Client With this name ");
	        } else {
	            showAlert("Success", "Client deleted successfully");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void evaluateClientAdminDeleteBook(String bookName, String authorName, int amount) {
	    try {
	        ResultSet resultSet = databaseDriver.deleteBook(bookName, authorName, amount);
	        if (resultSet == null) {
	            showAlert("Error", "Book not deleted or No such Book With this name, author, and amount");
	        } else {
	            showAlert("Success", "Book deleted successfully");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void evaluateClientAdminAddOrUpdateBook(String bookName, String authorName, int amount) {
	    try {
	        ResultSet resultSet = databaseDriver.addOrUpdateBook(bookName, authorName, amount);
	        if (resultSet == null) {
	            showAlert("Error", "Book not added or updated");
	        } else {
	                // If the ResultSet is empty, it means the book was added
	                showAlert("Success", "Book added successfully");
	            }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public void evaluateClientBuyBook(String bookName, String authorName, int amount) {
	    try {
	        ResultSet resultSet = databaseDriver.deleteBook(bookName, authorName, amount);
	        if (resultSet == null) {
	            showAlert("Atention", "No such Book With this name, author, and amount");
	        } else {
	            showAlert("Success!"," Book purchased successfully.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
/*
    if (resultSet.next()) {
        // If the ResultSet has a next row, it means the book already existed, so it's an update
        showAlert("Success", "Book updated successfully");
    } else {
*/
	
	//constructor fo the observable list
	public ObservableList<Client> getClients(){
		
		return clients;
	}
	
public ObservableList<Book> getBooks(){
		
		return books;
	}


	
	
	
	//setter to set the data of the list 
	public void setClients() {
		ResultSet resultSet =databaseDriver.getAllClientsData();
		try {
			
			while(resultSet.next()) {
				String Name = resultSet.getString("client_name");
				String Pass = resultSet.getString("pass");
				clients.add(new Client (Name,Pass));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void setBooks() {
		ResultSet resultSet =databaseDriver.getAllBooksData();
		try {
			
			while(resultSet.next()) {
				String Book_Name = resultSet.getString("book_name");
				String author = resultSet.getString("author_name");
				 int amount = (int)resultSet.getInt("amount");
				books.add(new Book (Book_Name,author,amount));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	 public void showAlert(String title, String message) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle(title);
         alert.setHeaderText(null);
         alert.setContentText(message);
         alert.showAndWait();
     }
	
	/*
	public void evaluateClientCred(String name, String password) {
		ResultSet resultSet  = databaseDriver.getClientData(name, password	);//hayde l getclient data hatayneha equal to  result set w rje3na hatana l if la nofhas eza fiya data aw eza radet chi ye3ne 
		try {
			if(resultSet.isBeforeFirst()) {
				this.client.nameProperty().set(resultSet.getString("client_name"));
				this.client.passwordProperty().set(resultSet.getString("pass"));
		        //hayde getclient data fi hal tole3 ma3a chi ha tredele enno la2en fa se3eta fi hal radet return ma3neta enno true 
				this.clientLoginSuccessFlag=true;//hek men8ayera la true
			
			
			}}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	

}

//hone sta3malna singleton pattern //wich mean is to create an object that we can access it anywhere in our program 
//and also we are sure that this is the same object not a copy of it metel l global bi c++
//fina tari2 tenye enno fina nesta3mel preconstructed controller to access the data throuw it 
