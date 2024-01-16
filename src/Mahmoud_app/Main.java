package Mahmoud_app;


import Mahmoud_app.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	
    @Override
    public void start(Stage primaryStage) {
       
    	Model.getInstance().getViewfactory().showLoginWindow();
    	
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
// l model bte5od men l view wel controiller bte5pd men l model w hek byonwoslo 3a ba3ed w kel wehde bikoun 3enda cha8leta 

//controller hiye silet l wasel l asesiye ye3ne hone masaln bel view li aktar chi nehna rqakazna 3le enno na3mel load men l fxml file w hatayneha kel wehde bi aleb scene w rje3na bel model nehna 
//rje3ne bel model hatayna logic w 3arrafna honik view factory w kamen 5ala2na constructor public bi hayda l model kermel men wara ne2dar nousal lal mopdel
//w e5er chi bel controllr hatayna kel companent chou byechte8e w a5adna nmetel 3melna import mne l model li houwe ken kamen e5ed men l view 