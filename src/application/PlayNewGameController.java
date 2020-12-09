package application;


//animation timer

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
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


public class PlayNewGameController extends AnimationTimer implements Serializable {
	
	
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
	@FXML public Button saveGameButton;
	
	@FXML public Pane gameOverPane;
	@FXML public Button resurrectButton;
	@FXML public Button gobackButton;
	@FXML public TextArea scoreTextArea;
	
	public ArrayList<Pane> obstacle = new ArrayList<>();
	public int count=0;
	public boolean levelDone=false;
	public int score=0;
	public int saveGameCount=0;
	//public boolean colorChanged=false;
	
	public void initialize(URL url, ResourceBundle resources)
	{
		
	}
	
	public void pause(ActionEvent e)
	{
		
	}
	public void resurrect()
	{
		// 5 stars needed per resurrection
		// it is assumed that score will also reduce
		
		if(score<1)
		{
			System.out.println("Not Enough Stars");
		}
		else
		{
			score-=1;
			scoreButton.setText("SCORE: "+score);
			ball.setVisible(true);
			System.out.print("here");
			ball.setLayoutY(790);
			gameOverPane.setVisible(false);
		}
	}
	
	public void gameOver() throws IOException
	{
		
		gameOverPane.setVisible(true);
		
		scoreTextArea.setText("Score is: "+score);
		//ball.setVisible(false);
		//PauseTransition pause = new PauseTransition(Duration.seconds(1000));
		//pause.play();
//		Parent t = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
//    	Scene ts = new Scene(t);
//    	
//    	//stage info
//    	Stage window = (Stage)(form.getScene().getWindow());
//    	
//    	window.setScene(ts);
//    	window.show();
	}
	
	public void gogoBack(ActionEvent event) throws IOException
	{
		Parent t = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
    	Scene ts = new Scene(t);
    	
    	//stage info
    	Stage window = (Stage)(((Node) event.getSource()).getScene().getWindow());
    	
    	window.setScene(ts);
    	window.show();
	}
	
	public void saveGame()
	{
		try {
			
			double yx = pane1.getLocalToSceneTransform().getMyx();
			double yy = pane1.getLocalToSceneTransform().getMyy();
			double angle = Math.atan2(yx, yy);
			angle = angle<0?angle+360:angle;
			
			Main2 obj = new Main2();
			obj.ballColour=ball.getStroke().toString();
			obj.ballY=ball.getLayoutY();
			obj.pane1Vis=pane1.isVisible();
			obj.pane2Vis=pane2.isVisible();
			obj.pane3Vis=pane3.isVisible();
			obj.score=score;
			obj.pane1Deg=angle;
			yx = pane2.getLocalToSceneTransform().getMyx();
			yy = pane2.getLocalToSceneTransform().getMyy();
			angle = Math.atan2(yx, yy);
			angle = angle<0?angle+360:angle;
			obj.pane2Deg=angle;
			yx = pane3.getLocalToSceneTransform().getMyx();
			yy = pane3.getLocalToSceneTransform().getMyy();
			angle = Math.atan2(yx, yy);
			angle = angle<0?angle+360:angle;
			obj.pane3Deg=angle;
			
			FileOutputStream fs = new FileOutputStream("SavedGames/savegame"+saveGameCount+".txt");
			saveGameCount++;
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(obj);
			os.close(); 
			System.out.println("written");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		levelDone=false;
		//colorChanged=false;
		star1.setVisible(true);
		star2.setVisible(true);
		star3.setVisible(true);
		ball.setLayoutY(790);
	}
	public boolean intersectObstacle()
	{	
		if(pane1.isVisible())
		{
			boolean b1 = Shape.intersect(ball, yellow1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(yellow1.getStroke());
			boolean b2 = Shape.intersect(ball, pink1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(pink1.getStroke());
			boolean b3 = Shape.intersect(ball, purple1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(purple1.getStroke());
			boolean b4 = Shape.intersect(ball, blue1).getBoundsInLocal().isEmpty()==false && !ball.getStroke().equals(blue1.getStroke());
			
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
			
			if(b && !levelDone)
			{
				score++;
				scoreButton.setText("Score: "+score);
				star1.setVisible(false);
				levelDone=true;
				System.out.println("got yo");
			}
			
		}
		
		if(pane2.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane2.getPrefHeight()+pane2.getLayoutY()-star2.getLayoutY();
			
			if(b && !levelDone)
			{
				score++;
				scoreButton.setText("Score: "+score);
				star2.setVisible(false);
				levelDone=true;
				System.out.println("got yo");
			}
			
		}
		
		if(pane3.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane3.getPrefHeight()+pane3.getLayoutY()-star3.getLayoutY();
			
			if(b && !levelDone)
			{
				score++;
				scoreButton.setText("Score: "+score);
				star3.setVisible(false);
				levelDone=true;
				System.out.println("got you there");
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
			//colorChanged=true;
			spawnObstacle();
		}
	}
	
	@Override
	public void handle(long x)
	{
		doHandle();
	}
	
	private void doHandle()
	{
		int j=50;
		while(true)
		{
			if(j<=0)
				stop();
			else
			{
				ball.setLayoutY(ball.getLayoutY()+5);
				j-=5;
			}
		}
	}
    public void jump() throws InterruptedException
    {
    	
    		double y = ball.getLayoutY();
    		System.out.println(y);
    		if(intersectObstacle())
				try {
					gameOver();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		    		
    		ball.setLayoutY((y+800-ball.getRadius()*3)%800);
    		
    			intersectStar();
                intersectColorChange();  
                
                
    		//System.out.println(y);
    	//	if(y<=10)
    		//	spawnObstacle();
//    			System.out.println("crossed page");
//    		
//        	AnimationTimer timer = new AnimationTimer() {
//        		@Override
//        		public void handle(long now)
//        		{
//        			doHandle();
//        		}
//        	};
//        	timer.start();
    		Bounds bounds = form.getBoundsInLocal();
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), 
                    new KeyValue(ball.layoutYProperty(), bounds.getMaxY()-ball.getRadius()/16)));
            timeline.setCycleCount(2);
            timeline.play(); 
            
            if(intersectObstacle())
				try {
					gameOver();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		 // set rotation speed here
	    	RotateTransition rt = new RotateTransition(Duration.seconds(160), a);
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
	    	System.out.println(window+" widnow");
	    	window.setScene(ts);
	    	window.show();
	    }
}
