package application;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.io.*; 


public class Main2 implements Serializable {
	private static final long serialVersionUID = 42L;
	
	public double ballY;
	public String ballColour;
	public int score;
	public boolean pane1Vis;
	public boolean pane2Vis;
	public boolean pane3Vis;
	public double pane1Deg;
	public double pane2Deg;
	public double pane3Deg;
//	@FXML public Button backButton;
//	@FXML public Button pauseButton;
//	
//	@FXML public AnchorPane form;
//	
//	@FXML public Pane pane1;
//	@FXML public Pane pane2;
//	@FXML public Pane pane3;
//	
//	@FXML public Arc yellow1;
//	@FXML public Arc pink1;
//	@FXML public Arc purple1;
//	@FXML public Arc blue1;
//	@FXML public Rectangle yellow2;
//	@FXML public Rectangle pink2;
//	@FXML public Rectangle purple2;
//	@FXML public Rectangle blue2;
//	@FXML public Rectangle yellow3;
//	@FXML public Rectangle pink3;
//	@FXML public Rectangle purple3;
//	@FXML public Rectangle blue3;
//	
//	@FXML public ImageView star1;
//	@FXML public ImageView star2;
//	@FXML public ImageView star3;
//	
//	@FXML public Rectangle colorChanger;
//	
//	@FXML public Circle ball;
//	
//	@FXML public Button scoreButton;
//	@FXML public Button saveGameButton;
//	
//	public ArrayList<Pane> obstacle = new ArrayList<>();
//	public int count=0;
//	public boolean levelDone=false;
	
	
}








