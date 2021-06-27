package application;


import java.io.File;
import java.io.FileInputStream;

//animation timer

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
import javafx.fxml.Initializable;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

class audioPlayer
{
	Clip clip;
	AudioInputStream audioInputStream;
	String path;
	
	public audioPlayer(String name) throws Exception 
	{
		File f = new File("/home/hardik/eclipse-workspace/kolor-sweech-penultimate/"+name);
		System.out.println(f);
		audioInputStream = AudioSystem.getAudioInputStream(new File("/home/hardik/eclipse-workspace/kolor-sweech-penultimate/music/"+name).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		//clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
	}	
}

public class PlayNewGameController implements Serializable, Initializable {
	
	
	@FXML protected Button backButton;
	@FXML protected Button pauseButton;
	@FXML protected Button resumeButton;
	
	@FXML protected AnchorPane form;
	
	@FXML protected Pane pane1;
	@FXML protected Pane pane2;
	@FXML protected Pane pane3;
	
	@FXML protected Arc yellow1;
	@FXML protected Arc pink1;
	@FXML protected Arc purple1;
	@FXML protected Arc blue1;
	@FXML protected Rectangle yellow2;
	@FXML protected Rectangle pink2;
	@FXML protected Rectangle purple2;
	@FXML protected Rectangle blue2;
	@FXML protected Rectangle yellow3;
	@FXML protected Rectangle pink3;
	@FXML protected Rectangle purple3;
	@FXML protected Rectangle blue3;
	
	@FXML protected ImageView star1;
	@FXML protected ImageView star2;
	@FXML protected ImageView star3;
	
	@FXML protected Rectangle colorChanger;
	
	@FXML protected Circle ball;
	
	@FXML protected Button scoreButton;
	@FXML protected Button saveGameButton;
	
	@FXML protected Pane gameOverPane;
	@FXML protected Button resurrectButton;
	@FXML protected Button gobackButton;
	@FXML protected TextArea scoreTextArea;
	
	protected ArrayList<Pane> obstacle = new ArrayList<>();
	protected int count=0;
	protected boolean levelDone=false;
	protected int score=0;
	protected int saveGameCount=0;
	protected boolean isPaused=false;
	//protected boolean colorChanged=false;
	
	@Override
	public void initialize(URL url, ResourceBundle resources)
	{
		System.out.print("initializing game");
	}
	
	public void pause(ActionEvent e)
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
			obj.resOnce=false;
			obj.pane1Star=star1.isVisible();
			obj.pane2Star=star2.isVisible();
			obj.pane3Star=star3.isVisible();
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
			
			FileOutputStream fs = new FileOutputStream("Pause/pause.txt");
			saveGameCount++;
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(obj);
			os.close(); 
			ball.setVisible(false);
			pane1.setVisible(false);
			pane2.setVisible(false);
			pane3.setVisible(false);
			System.out.println("Game Paused");
			isPaused=true;
		} catch (Exception ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		}
	}
	
	public void resumeGame(ActionEvent ev)
	{
		Stage stage = (Stage)form.getScene().getWindow();
		stage.close();
		
		Main2 desObj = new Main2();
		ObjectInputStream in = null;
		
		try
		{
			isPaused=false;
			FileInputStream file = new FileInputStream("Pause/pause.txt");
			in = new ObjectInputStream(file);
			desObj = (Main2)in.readObject();
			file.close();
			in.close();
			try
			{
				Parent root = FXMLLoader.load(getClass().getResource("PlayNewGame.fxml"));
				stage.setUserData(desObj);
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show(); 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void resurrect()
	{
		// 2 stars needed per resurrection
		// it is assumed that score will also reduce
		
		if(score<2)
		{
			System.out.println("Not Enough Stars. Game truly over. Play again :)");
		}
		else
		{
			score-=2;
			System.out.println("Player revived!!");
			scoreButton.setText("SCORE: "+score);
			ball.setVisible(true);
			System.out.print("here");
			ball.setLayoutY(790);
			gameOverPane.setVisible(false);
			try {
				audioPlayer p = new audioPlayer("magic.wav");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void gameOver() throws IOException
	{
		
		int scoree=0;
		try {
		File f = new File("/home/hardik/eclipse-workspace/kolor-sweech-penultimate/Leaderboard/score.txt");
		Scanner sc;
			sc = new Scanner(f);
			scoree=Integer.parseInt(sc.nextLine());
			sc.close();
			if(score>scoree)
				scoree=score;
			FileWriter write = new FileWriter("/home/hardik/eclipse-workspace/kolor-sweech-penultimate/Leaderboard/score.txt");
			write.write(""+scoree);
			write.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(highScoreLabel);
		
		
		try {
			audioPlayer p = new audioPlayer("explode.wav");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameOverPane.setVisible(true);
		scoreTextArea.setText("Score is: "+score);
		ball.setVisible(false);
		
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
		if(isPaused==true)
			return;
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
			obj.resOnce=false;
			obj.pane1Star=star1.isVisible();
			obj.pane2Star=star2.isVisible();
			obj.pane3Star=star3.isVisible();
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
			System.out.println("game saved! in file savegame"+saveGameCount+".txt");
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
			{
				System.out.println("Collision with obstacle detected!!");
				return true;
			}
		}
		
		if(pane2.isVisible())
		{
			boolean b1 = Shape.intersect(ball, yellow2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(yellow2.getFill());
			boolean b2 = Shape.intersect(ball, pink2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(pink2.getFill());
			boolean b3 = Shape.intersect(ball, purple2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(purple2.getFill());
			boolean b4 = Shape.intersect(ball, blue2).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(blue2.getFill());
			
			if(b1 || b2 || b3 || b4) 
			{
				System.out.println("Collision with obstacle detected!!");
				return true;
			}	
		}
		
		if(pane3.isVisible())
		{
			boolean b1 = Shape.intersect(ball, yellow3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(yellow3.getFill());
			boolean b2 = Shape.intersect(ball, pink3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(pink3.getFill());
			boolean b3 = Shape.intersect(ball, purple3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(purple3.getFill());
			boolean b4 = Shape.intersect(ball, blue3).getBoundsInLocal().isEmpty()==false && !ball.getFill().equals(blue3.getFill());
			
			if(b1 || b2 || b3 || b4) 
			{
				System.out.println("Collision with obstacle detected!!");
				return true;
			}	
		}
		return false; 
		
	}
	
	public void intersectStar()
	{
		if(pane1.isVisible() && star1.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane1.getPrefHeight()+pane1.getLayoutY()-star1.getLayoutY();
			
			if(b && !levelDone)
			{
				try {
					audioPlayer p = new audioPlayer("star.wav");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				score++;
				scoreButton.setText("Score: "+score);
				star1.setVisible(false);
				levelDone=true;
				System.out.println("got yo");
			}
			
		}
		
		if(pane2.isVisible() && star2.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane2.getPrefHeight()+pane2.getLayoutY()-star2.getLayoutY();
			
			if(b && !levelDone)
			{
				try {
					audioPlayer p = new audioPlayer("star.wav");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				score++;
				scoreButton.setText("Score: "+score);
				star2.setVisible(false);
				levelDone=true;
				System.out.println("got yo");
			}
			
		}
		
		if(pane3.isVisible() && star3.isVisible())
		{
			boolean b = ball.getLayoutY() <= pane3.getPrefHeight()+pane3.getLayoutY()-star3.getLayoutY();
			
			if(b && !levelDone)
			{
				try {
					audioPlayer p = new audioPlayer("star.wav");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
	
	
    public void jump() throws InterruptedException
    {
    	try {
			audioPlayer p = new audioPlayer("jump.wav");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
    }
    
    
	public void rotateRing() throws InterruptedException
	{
		
		Stage stage = (Stage)form.getScene().getWindow();
		Main2 savedObj = (Main2)stage.getUserData();
		if(savedObj==null)
			System.out.print("nothing saved yet");
		else if(!savedObj.resOnce)
		{
			savedObj.resOnce=true;
			System.out.println(savedObj.ballColour);
			ball.setLayoutY(savedObj.ballY);
			ball.setFill(Color.web(savedObj.ballColour));
			ball.setStroke(Color.web(savedObj.ballColour));
			score=savedObj.score;
			scoreButton.setText("Score: "+score);
			pane1.setVisible(savedObj.pane1Vis);
			pane2.setVisible(savedObj.pane2Vis);
			pane3.setVisible(savedObj.pane3Vis);
			
			star1.setVisible(savedObj.pane1Star);
			star2.setVisible(savedObj.pane2Star);
			star3.setVisible(savedObj.pane3Star);
		}
		
		savedObj=null;
		
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
	    	
	    	window.setScene(ts);
	    	window.show();
	    }
}
