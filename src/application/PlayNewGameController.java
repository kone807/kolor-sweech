package application;




import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PlayNewGameController {
	
	
	@FXML public Button backButton;
	@FXML public Button pauseButton;
	
	@FXML public AnchorPane form;
	@FXML public Pane pane1;
	@FXML public Arc yellow;
	@FXML public Arc pink;
	@FXML public Arc purple;
	@FXML public Arc blue;
	
	@FXML public Rectangle colorChanger;
	
	@FXML public Circle ball;
	
	public boolean intersectObstacle()
	{
		boolean b1 = Shape.intersect(ball, yellow).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(yellow.getStroke());
		boolean b2 = Shape.intersect(ball, pink).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(pink.getStroke());
		boolean b3 = Shape.intersect(ball, purple).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(purple.getStroke());
		boolean b4 = Shape.intersect(ball, blue).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(blue.getStroke());
		
		if(b1 || b2 || b3 || b4) 
		return true;
		return false;
	}
	
	public void intersectColorChange()
	{
		boolean b = Shape.intersect(colorChanger, ball).getBoundsInLocal().isEmpty()==false;
		
		if(b) 
		{
			Colour p = new Colour();
			Color c = (Color)ball.getFill();
			Color newColour = p.getNewColor(c);
			//System.out.println(newColour+" "+ball.getFill());
			ball.setFill(newColour);
			ball.setStroke(newColour);
		}
	}
	
    public void jump()
    {
    	
    		double y = ball.getLayoutY();
    		//System.out.println(y);
    		if(y<=100)
    			System.out.println("crossed page");
    		
    		ball.setLayoutY((y+800-ball.getRadius()*3)%800);
    		
    		Bounds bounds = form.getBoundsInLocal();
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), 
                    new KeyValue(ball.layoutYProperty(), bounds.getMaxY()-ball.getRadius()/16)));
            timeline.setCycleCount(2);
            timeline.play();
            
            if(intersectObstacle())
            {}//System.out.println("Collision!!!!");
            intersectColorChange();  
            
    }
	public void rotateRing() throws InterruptedException
	{
		setRotate(pane1, 360, 1);
	}
	
	 public void setRotate(Pane a, int angle, int duration)
	    {
	    	RotateTransition rt = new RotateTransition(Duration.seconds(125), a);
	    	rt.setFromAngle(0);
	    	rt.setToAngle(720*30);
	    	rt.setCycleCount(3);
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
