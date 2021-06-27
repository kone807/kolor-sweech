package application;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class User implements Serializable{
	private static final long serialVersionUID = 37L;
	
	protected Ball ball;
	protected Star star;
	protected int score;
	
	public User()
	{
		score=0;
	}
}
