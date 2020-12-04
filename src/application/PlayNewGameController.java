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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PlayNewGameController {
	
	
	@FXML public Button backButton;
	
	@FXML public AnchorPane form;
	@FXML public Arc yellow;
	@FXML public Arc pink;
	@FXML public Arc purple;
	@FXML public Arc blue;
	@FXML public Group gp;
	
	@FXML public Circle ball;
	
     
    public void jump(KeyEvent e)
    {
    	//System.out.println("here");
    	if(e.getCode()==KeyCode.J)
    	{
    		double y = ball.getLayoutY();
    		ball.setLayoutY((y+800-10)%800);
    	}
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
