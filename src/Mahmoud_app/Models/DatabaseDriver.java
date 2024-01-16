package Mahmoud_app.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseDriver {
//this file will connect to the databse and it will define the functions that we want to use 
	//fina nektbo de8re bel model class bas asmnehon kermel nazemoon aktar 
	private Connection connection;
	
	public DatabaseDriver() {
		try {
			this.connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book_Management_System","root","passwordsql123");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//utility ye3ne tnayneton fiyon ysta3mlouwon


	/*
	 *Client Section 
	 * 
	 * 
	 * */
	public ResultSet getClientData(String name, String password) {
	    Statement statement;
	    ResultSet resultSet = null;
	    try {
	        statement = this.connection.createStatement();
	        resultSet = statement.executeQuery("SELECT * FROM Clients WHERE client_name='" + name + "' AND pass='" + password + "'");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultSet; // return the actual ResultSet instead of null
	}



	/*
	 *Admin Section 
	 * 
	 * 
	 * 
	 * */
	
	public ResultSet getAdminData(String name, String password) {
	    Statement statement;
	    ResultSet resultSet = null;
	    try {
	        statement = this.connection.createStatement();
	        resultSet = statement.executeQuery("SELECT * FROM Admins WHERE admin_name='" + name + "' AND pass='" + password + "'");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultSet; // return the actual ResultSet instead of null
	}

	
	//method to add client by the admin
	public ResultSet insertNewClient(String clientName, String password) {
	    String query = "INSERT INTO Clients (client_name, pass) VALUES (?, ?)";
	    ResultSet generatedKeys = null;

	    try (PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	        preparedStatement.setString(1, clientName);
	        preparedStatement.setString(2, password);

	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check if the insertion was successful
	        if (rowsAffected > 0) {
	            // Retrieve the generated keys (if any)
	            generatedKeys = preparedStatement.getGeneratedKeys();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return generatedKeys;
	}

	
	//method to delete client by the admin 
	
	public ResultSet deleteClient(String clientName) {
	    String query = "DELETE FROM Clients WHERE client_name = ?";
	    ResultSet generatedKeys = null;

	    try (PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	        preparedStatement.setString(1, clientName);

	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check if the deletion was successful
	        if (rowsAffected > 0) {
	            // Retrieve the generated keys (if any)
	            generatedKeys = preparedStatement.getGeneratedKeys();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return generatedKeys;
	}

   
	//this function is used by the user to add a new books or to add a new amount to an existing book
	
	
	//we divide the add and update function into two parts because whenever an sql query is executed in the same methos so automaticly we loose the connection to the database
	//this a boolean function to check if the book exist 
	public boolean doesBookExist(String bookName, String authorName) {
	    String querySelect = "SELECT COUNT(*) FROM Books WHERE book_name = ? AND author_name = ?";
	    boolean bookExists = false;

	    try (PreparedStatement preparedStatement = this.connection.prepareStatement(querySelect)) {
	        preparedStatement.setString(1, bookName);
	        preparedStatement.setString(2, authorName);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                bookExists = count > 0;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return bookExists;
	}

	
	public ResultSet addOrUpdateBook(String bookName, String authorName, int amount) {
	    String queryUpdate = "UPDATE Books SET amount = amount + ? WHERE book_name = ? AND author_name = ?";
	    String queryInsert = "INSERT INTO Books (book_name, author_name, amount) VALUES (?, ?, ?)";
	    ResultSet generatedKeys = null;

	    try {

	            if (doesBookExist(bookName, authorName)==true) {
	                // Book exists, update the amount
	                try (PreparedStatement updateStatement = this.connection.prepareStatement(queryUpdate, Statement.RETURN_GENERATED_KEYS)) {
	                    updateStatement.setInt(1, amount);
	                    updateStatement.setString(2, bookName);
	                    updateStatement.setString(3, authorName);

	                    int rowsAffected = updateStatement.executeUpdate();

	                    // Check if the update was successful
	                    if (rowsAffected > 0) {
	                        // Retrieve the generated keys (if any)
	                        generatedKeys = updateStatement.getGeneratedKeys();
	                    }
	                }
	            } else {
	                // Book does not exist, insert a new record
	                try (PreparedStatement insertStatement = this.connection.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
	                    insertStatement.setString(1, bookName);
	                    insertStatement.setString(2, authorName);
	                    insertStatement.setInt(3, amount);

	                    int rowsAffected = insertStatement.executeUpdate();

	                    // Check if the insertion was successful
	                    if (rowsAffected > 0) {
	                        // Retrieve the generated keys (if any)
	                        generatedKeys = insertStatement.getGeneratedKeys();
	                    }
	                }
	            }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return generatedKeys;
	}
	
	
	
	///this method is to display all the clients in the clientListView of the admin 
	
	public ResultSet getAllClientsData() {
		
		Statement statement ;
		ResultSet resultSet = null;
		try {
		statement =this.connection.createStatement();
		resultSet = statement.executeQuery("Select * from Clients;");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
		
	}


	


	/*
	 *Utility Section 
	 * 
	 * 
	 * */
	
	// method to delete books by the admin 
		//this method is used by both the admin and the user 
		public ResultSet deleteBook(String bookName, String authorName, int amount) {
		    String query = "UPDATE Books SET amount = amount - ? WHERE book_name = ? AND author_name = ? AND amount >= ?";
		    ResultSet generatedKeys = null;

		    try (PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
		        preparedStatement.setInt(1, amount);
		        preparedStatement.setString(2, bookName);
		        preparedStatement.setString(3, authorName);
		        preparedStatement.setInt(4, amount);

		        int rowsAffected = preparedStatement.executeUpdate();

		        // Check if the update was successful
		        if (rowsAffected > 0) {
		            // Retrieve the generated keys (if any)
		            generatedKeys = preparedStatement.getGeneratedKeys();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return generatedKeys;
		}
	    
		
		//
		//this method is used to display all books in the view list of the client and admin
		
		
		public ResultSet getAllBooksData() {
			
			Statement statement ;
			ResultSet resultSet = null;
			try {
			statement =this.connection.createStatement();
			resultSet = statement.executeQuery("Select * from Book_Management_System.Books;");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return resultSet;
			
		}

	
	
}
 
 