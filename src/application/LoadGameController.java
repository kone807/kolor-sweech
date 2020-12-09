package application;





import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoadGameController implements Initializable{
	
	@FXML public AnchorPane form;
	@FXML public Button backButton;
	@FXML public TextArea saveGameArea;
	
	
	@Override
	public void initialize(URL url, ResourceBundle resource)
	{
		File folder = new File("SavedGames");
		File[] listOfFiles = folder.listFiles();

		ArrayList<Button> allButton = new ArrayList<Button>();
		
		int Ycor = 93;
		
		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    String name = listOfFiles[i].getName();
		    Button b = new Button(name);
		    b.setPrefWidth(250);
		    b.setPrefHeight(50);
		    b.setFont(Font.font("System", 24));
		    b.setEffect(new Lighting());
		    b.setTranslateX(200);
		    b.setTranslateY(Ycor);
		    Color c = Color.web("#ffd23c");
		    Ycor += 100;
		    b.setOnAction(new EventHandler<ActionEvent>() {

         	  @Override
         	  public void handle(ActionEvent e) {
         		  loadFile(b.getText());		  
     	  }
     	});
		    
		    allButton.add(b);
		  }
		}
		
		form.getChildren().addAll(allButton);
		
	}
	
	public void loadFile(String fileName)
	{
		Main2 desObj = new Main2();
		System.out.println(fileName);
		Parent t;
		try {
			t = FXMLLoader.load(getClass().getResource("PlayNewGame.fxml"));
			Scene ts = new Scene(t);
	    	
	    	//stage info
	    	Stage window = (Stage)(form.getScene().getWindow());
	    	
	    	window.setScene(ts);
	    	window.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			FileInputStream file = new FileInputStream("SavedGames/"+fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			desObj=(Main2)in.readObject();
			file.close();
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(desObj.ballColour);
    	
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
