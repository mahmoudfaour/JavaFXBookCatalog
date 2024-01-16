package Mahmoud_app.Controllers;

import java.net.URL;

import java.sql.SQLException;
import java.util.ResourceBundle;

import Mahmoud_app.Models.Model;
import Mahmoud_app.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
        
        public ChoiceBox<AccountType> acc_selector;
        public Label FullName_lbl; 
        public TextField FullName_field;
        public TextField pass_field;
        public Button login_btn; 
		public Label error_lbl;
        
        
        @Override
    	public void initialize(URL url, ResourceBundle resourceBundle) {
    		
            acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT ,AccountType.ADMIN));
            acc_selector.setValue(Model.getInstance().getViewfactory().getLoginAccountType());
            acc_selector.valueProperty().addListener(observable ->Model.getInstance().getViewfactory().setLoginAccountType(acc_selector.getValue()));
        	login_btn.setOnAction(e -> onLogin());
        	
    	}
        
        
        private void onLogin() {
        	Stage stage =(Stage) error_lbl.getScene().getWindow();//hone li 3melne enno ederna metel nestantej l stage login men 5ilel hayda l label li bi alba lal stage w kamen 3melna casting lal window la ysir kamen stage la ne2dar nsakro
        	Model.getInstance().getViewfactory().closeStage(stage);
        	if(Model.getInstance().getViewfactory().getLoginAccountType() == AccountType.CLIENT)
        	{//hone mna3mel evaluate client login credentials
        		boolean response;
        		response=Model.getInstance().evaluateClientCred(FullName_field.getText(), pass_field.getText());
        		
        		if(response==true){//ma mna3mel == true ye3ne fina ma nhota by default 3am bet2aren
        		Model.getInstance().getViewfactory().showClientWindow();}else {
        			
        			Model.getInstance().getViewfactory().showLoginWindow();;
        			showAlert("ERROR", "please enter a valid login credentials for the client ");
        			
        		}
        		
        	}
        	else if(Model.getInstance().getViewfactory().getLoginAccountType() == AccountType.ADMIN) {
        		boolean response;
        		response=Model.getInstance().evaluateAdminCred(FullName_field.getText(), pass_field.getText());
        		if(response==true){//ma mna3mel == true ye3ne fina ma nhota by default 3am bet2aren
        			Model.getInstance().getViewfactory().showAdminWindow();}else {
            			
            			Model.getInstance().getViewfactory().showLoginWindow();;
            			showAlert("ERROR", "please enter a valid login credentials for the admin ");
        		
        	}
        }}
        
        
        private void showAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
        
    }

