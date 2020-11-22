package application;




import java.io.IOException;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainScreenController {
	
	
	@FXML public Button playGameButton;
	@FXML public Button loadGameButton;
	@FXML public Button instructionsButton;
	@FXML public Button aboutButton;
	@FXML public Button exitButton;
	
	@FXML public AnchorPane form;
	@FXML public Arc yellow;
	@FXML public Arc pink;
	@FXML public Arc purple;
	@FXML public Arc blue;
	@FXML public Group gp;
	
	public void rotateRing()
	{
		setRotate(gp, 360, 1);
	}
	
	 public void setRotate(Group a, int angle, int duration)
	    {
	    	RotateTransition rt = new RotateTransition(Duration.seconds(50), a);
	    	rt.setFromAngle(0);
	    	rt.setToAngle(720*30);
	    	rt.setCycleCount(3);
	    	//rt.setRate(20);
	    	//rt.setCycleCount((int)Double.POSITIVE_INFINITY);
	    	rt.play();
	    	}
	 
    public void playGame(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("PlayNewGame.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
    } 
    
    public void loadGame(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
    } 
    
    public void showInstructions(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
    } 
    
    public void showAbout(ActionEvent event) throws IOException
    {
    	Parent t = FXMLLoader.load(getClass().getResource("About.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
    } 
    
    public void exitGame(ActionEvent event) throws IOException
    {
    	System.exit(0);

    } 
}
