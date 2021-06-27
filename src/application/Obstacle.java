package application;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class Obstacle implements Serializable{
	private static final long serialVersionUID = 32L;
	
	@FXML protected Pane pane;
	@FXML protected Arc a1;
	@FXML protected Arc a2;
	@FXML protected Arc a3;
	@FXML protected Arc a4;
	
	public Obstacle()
	{
		
	}
}
