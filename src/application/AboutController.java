package application;




import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AboutController {
	
	
@FXML public Button backButton;
	
    public void goBack(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
    }
}
