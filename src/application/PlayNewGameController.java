package application;




import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
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
import javafx.scene.image.ImageView;
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


public class PlayNewGameController implements Serializable{
	
	
	@FXML public Button backButton;
	@FXML public Button pauseButton;
	
	@FXML public AnchorPane form;
	
	@FXML public Pane pane1;
	@FXML public Pane pane2;
	@FXML public Pane pane3;
	
	@FXML public Arc yellow1;
	@FXML public Arc pink1;
	@FXML public Arc purple1;
	@FXML public Arc blue1;
	@FXML public Rectangle yellow2;
	@FXML public Rectangle pink2;
	@FXML public Rectangle purple2;
	@FXML public Rectangle blue2;
	@FXML public Rectangle yellow3;
	@FXML public Rectangle pink3;
	@FXML public Rectangle purple3;
	@FXML public Rectangle blue3;
	
	@FXML public ImageView star1;
	@FXML public ImageView star2;
	@FXML public ImageView star3;
	
	@FXML public Rectangle colorChanger;
	
	@FXML public Circle ball;
	
	@FXML public Button scoreButton;
	
	public ArrayList<Pane> obstacle = new ArrayList<>();
	public int count=0;
	
	public void initialize(URL url, ResourceBundle resources)
	{
		
	}
	
	public void spawnObstacle()
	{
		int n = obstacle.size();
		for(int i=0; i<n; i++)
		{
			if(i==count)
				obstacle.get(i).setVisible(true);
			else
				obstacle.get(i).setVisible(false);
		}
		Random rand = new Random();
		count=rand.nextInt(3);
	}
	public boolean intersectObstacle()
	{	
		if(pane1.isVisible())
		{
			boolean b1 = Shape.intersect(ball, yellow1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(yellow1.getStroke());
			boolean b2 = Shape.intersect(ball, pink1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(pink1.getStroke());
			boolean b3 = Shape.intersect(ball, purple1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(purple1.getStroke());
			boolean b4 = Shape.intersect(ball, blue1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(blue1.getStroke());
			
			if(b4)
			System.out.println(ball.getFill()+" "+blue1.getFill());
			if(b1 || b2 || b3 || b4) 
			return true;
		}
		
		if(pane2.isVisible())
		{
			boolean b1 = Shape.intersect(ball, yellow2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(yellow2.getFill());
			boolean b2 = Shape.intersect(ball, pink2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(pink2.getFill());
			boolean b3 = Shape.intersect(ball, purple2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(purple2.getFill());
			boolean b4 = Shape.intersect(ball, blue2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(blue2.getFill());
			
			if(b1 || b2 || b3 || b4) 
			return true;	
		}
		
		if(pane3.isVisible())
		{
			boolean b1 = Shape.intersect(ball, yellow3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(yellow3.getFill());
			boolean b2 = Shape.intersect(ball, pink3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(pink3.getFill());
			boolean b3 = Shape.intersect(ball, purple3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(purple3.getFill());
			boolean b4 = Shape.intersect(ball, blue3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(blue3.getFill());
			
			if(b1 || b2 || b3 || b4) 
			return true;	
		}
		return false; 
		
	}
	
	public void intersectStar()
	{
		if(pane1.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane1.getPrefHeight()+pane1.getLayoutY()-star1.getLayoutY();
			
			if(b)
			{
				int s = Integer.parseInt(scoreButton.getText().substring(7));
				s++;
				scoreButton.setText("Score: "+s);
				System.out.println("got yo");
			}
			
		}
		
		if(pane2.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane2.getPrefHeight()+pane2.getLayoutY()-star2.getLayoutY();
			
			if(b)
			{
				int s = Integer.parseInt(scoreButton.getText().substring(7));
				s++;
				scoreButton.setText("Score: "+s);
				System.out.println("got yo");
			}
			
		}
		
		if(pane3.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane3.getPrefHeight()+pane3.getLayoutY()-star3.getLayoutY();
			
			if(b)
			{
				int s = Integer.parseInt(scoreButton.getText().substring(7));
				s++;
				scoreButton.setText("Score: "+s);
				System.out.println("got yo");
			}
			
		}
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
    		if(intersectObstacle())
                System.out.println("Collision!!!!");
                intersectColorChange();  
                intersectStar();
                
    		//System.out.println(y);
    		if(y<=85)
    			spawnObstacle();
//    			System.out.println("crossed page");
    		
    		ball.setLayoutY((y+800-ball.getRadius()*3)%800);
    		
    		Bounds bounds = form.getBoundsInLocal();
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), 
                    new KeyValue(ball.layoutYProperty(), bounds.getMaxY()-ball.getRadius()/16)));
            timeline.setCycleCount(2);
            timeline.play();
          //  pane1.setVisible(false);
    }
    
    
	public void rotateRing() throws InterruptedException
	{
		obstacle.add(pane1);
		obstacle.add(pane2);
		obstacle.add(pane3);
		
		setRotate(pane1, 360, 1);
		setRotate(pane2, 360, 1);
		setRotate(pane3, 360, 1);
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
