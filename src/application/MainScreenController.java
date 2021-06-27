package application;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainScreenController implements Initializable{
	
	
	@FXML protected Button playGameButton;
	@FXML protected Button loadGameButton;
	@FXML protected Button instructionsButton;
	@FXML protected Button aboutButton;
	@FXML protected Button exitButton;
	
	@FXML protected AnchorPane form;
	@FXML protected Arc yellow;
	@FXML protected Arc pink;
	@FXML protected Arc purple;
	@FXML protected Arc blue;
	@FXML protected Group gp;
	
	@FXML protected Label highScoreLabel;
	
	@Override
	public void initialize(URL url, ResourceBundle res)
	{
		int score=0;
		try {
		File f = new File("/home/hardik/eclipse-workspace/kolor-sweech-penultimate/Leaderboard/score.txt");
		Scanner sc;
			sc = new Scanner(f);
			score=Integer.parseInt(sc.nextLine());
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(highScoreLabel);
		highScoreLabel.setText(""+score);
		
	}
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
