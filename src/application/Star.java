package application;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class Star implements Serializable{
	private static final long serialVersionUID = 36L;
	
	@FXML protected Pane pane;
	@FXML protected ImageView img;
	protected boolean isCollected;
	Star()
	{
		isCollected=false;
	}
}
