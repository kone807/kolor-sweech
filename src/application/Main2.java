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
	
	protected double ballY;
	protected String ballColour;
	protected int score;
	protected boolean pane1Vis;
	protected boolean pane2Vis;
	protected boolean pane3Vis;
	protected boolean pane1Star;
	protected boolean pane2Star;
	protected boolean pane3Star;
	protected double pane1Deg;
	protected double pane2Deg;
	protected double pane3Deg;
	protected boolean resOnce;

}








