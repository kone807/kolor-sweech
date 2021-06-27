package application;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class Game implements Serializable{
	private static final long serialVersionUID = 55L;
	
	protected ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	protected User user;
	
	public Game()
	{
		user.score=0;
	}
}
