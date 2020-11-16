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


public class MainScreenController {
	
	
	@FXML public Button playGameButton;
	@FXML public Button loadGameButton;
	@FXML public Button instructionsButton;
	@FXML public Button aboutButton;
	@FXML public Button exitButton;
	
    public void playGame(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("PlayNewGame.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
       System.out.println("I was clicked");
      // button.setText("name change!!");
    } 
    
    public void loadGame(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
       System.out.println("I was clicked");
       //button.setText("name change!!");
    } 
    
    public void showInstructions(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
       System.out.println("I was clicked");
      // button.setText("name change!!");
    } 
    
    public void showAbout(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("About.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
       System.out.println("I was clicked");
      // button.setText("name change!!");
    } 
    
    public void exitGame(ActionEvent event) throws IOException
    {
    	System.exit(0);
//    	Parent t = FXMLLoader.load(getClass().getResource("PlayNewGame.fxml"));
//    	Scene ts = new Scene(t);
//    	
//    	//stage info
//    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
//    	
//    	window.setScene(ts);
//    	window.show();
//       System.out.println("I was clicked");
       //button.setText("name change!!");
    } 
}
