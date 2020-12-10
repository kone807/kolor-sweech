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
		Stage stage = (Stage)form.getScene().getWindow();
		stage.close();
		
		Main2 desObj = new Main2();
		ObjectInputStream in = null;
		
		try
		{
			FileInputStream file = new FileInputStream("SavedGames/"+fileName);
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
		
		
		System.out.println(desObj.ballColour+" "+desObj.score);
		
	/*	try
		{
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} */
		
	/*	System.out.println(fileName);
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
		
		System.out.println(desObj.ballColour); */
    	
	}
	
	public void create()
	{
		
		/*AnchorPane form = new AnchorPane();
		form.setStyle(arg0);
		<AnchorPane fx:id="form" onMouseClicked="#jump" onMouseEntered="#rotateRing" prefHeight="800.0" prefWidth="600.0" style="-fx-background-color: black;" xmlns="http://javafx.com/javafx/11.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="application.PlayNewGameController">
		   <children>
		      <Group fx:id="gp1" layoutX="202.0" layoutY="305.0" />
		      <Circle fx:id="ball" fill="#ff0181" layoutX="311.0" layoutY="728.0" radius="20.0" stroke="#ff0181" strokeType="INSIDE" />
		      <Button fx:id="backButton" layoutX="38.0" layoutY="42.0" mnemonicParsing="false" onAction="#goBack" prefHeight="50.0" prefWidth="114.0" text="BACK">
		         <font>
		            <Font name="System Bold" size="24.0" />
		         </font>
		         <effect>
		            <Lighting>
		               <bumpInput>
		                  <Shadow />
		               </bumpInput>
		               <light>
		                  <Light.Distant color="#ffd23c" />
		               </light>
		            </Lighting>
		         </effect>
		         <textFill>
		            <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		               <stops>
		                  <Stop color="#b06b6b" />
		                  <Stop color="#f81212" offset="1.0" />
		               </stops>
		            </RadialGradient>
		         </textFill>
		      </Button>
		      <Button fx:id="pauseButton" layoutX="462.0" layoutY="42.0" mnemonicParsing="false" onAction="#pause" prefHeight="50.0" prefWidth="114.0" text="PAUSE">
		         <font>
		            <Font name="System Bold" size="24.0" />
		         </font>
		         <effect>
		            <Lighting>
		               <bumpInput>
		                  <Shadow />
		               </bumpInput>
		               <light>
		                  <Light.Distant color="#ffd23c" />
		               </light>
		            </Lighting>
		         </effect>
		         <textFill>
		            <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		               <stops>
		                  <Stop color="#b06b6b" />
		                  <Stop color="#f81212" offset="1.0" />
		               </stops>
		            </RadialGradient>
		         </textFill>
		      </Button>
		      <Rectangle fx:id="colorChanger" arcHeight="5.0" arcWidth="5.0" fill="WHITE" height="23.0" layoutX="298.0" layoutY="3.0" stroke="BLACK" strokeType="INSIDE" width="26.0" />
		      <Pane fx:id="pane3" layoutX="235.0" layoutY="204.0" prefHeight="328.0" prefWidth="325.0" visible="false">
		         <children>
		            <ImageView fx:id="star3" fitHeight="99.0" fitWidth="106.0" layoutX="113.0" pickOnBounds="true" preserveRatio="true">
		               <image>
		                  <Image url="@../../images/star.png" />
		               </image>
		            </ImageView>
		            <Rectangle fx:id="blue3" arcHeight="5.0" arcWidth="5.0" fill="#32dbf0" height="30.0" layoutX="117.0" layoutY="80.0" rotate="135.0" stroke="#32dbf0" strokeType="INSIDE" width="200.0" />
		            <Rectangle fx:id="pink3" arcHeight="5.0" arcWidth="5.0" fill="#ff0181" height="30.0" layoutX="117.0" layoutY="206.0" rotate="45.0" stroke="#ff0181" strokeType="INSIDE" width="200.0" />
		            <Rectangle fx:id="yellow3" arcHeight="5.0" arcWidth="5.0" fill="#e2ff00" height="30.0" layoutX="-5.0" layoutY="206.0" rotate="135.0" stroke="#e2ff00" strokeType="INSIDE" width="200.0" />
		            <Rectangle fx:id="purple3" arcHeight="5.0" arcWidth="5.0" fill="#900dff" height="30.0" layoutX="-5.0" layoutY="80.0" rotate="45.0" stroke="#900dff" strokeType="INSIDE" width="200.0" />
		         </children>
		      </Pane>
		      <Pane fx:id="pane1" layoutX="147.0" layoutY="219.0" prefHeight="335.0" prefWidth="346.0">
		         <children>
		            <Arc fx:id="yellow1" centerX="10.0" centerY="15.0" fill="#e2ff0000" layoutX="20.0" layoutY="141.0" length="90.0" radiusX="125.0" radiusY="125.0" rotate="270.0" stroke="#e2ff00" strokeWidth="30.0" />
		            <Arc fx:id="purple1" centerX="110.0" centerY="15.0" fill="#900dff00" layoutX="74.0" layoutY="140.0" length="90.0" radiusX="125.0" radiusY="125.0" stroke="#900dff" strokeWidth="30.0" />
		            <Arc fx:id="blue1" centerX="10.0" centerY="120.0" fill="#32dbf000" layoutX="21.0" layoutY="183.0" length="90.0" radiusX="125.0" radiusY="125.0" rotate="180.0" stroke="#32dbf0" strokeWidth="30.0" />
		            <Arc fx:id="pink1" centerX="110.0" centerY="120.0" fill="#ff018100" layoutX="74.0" layoutY="182.0" length="90.0" radiusX="125.0" radiusY="125.0" rotate="90.0" stroke="#ff0181" strokeWidth="30.0" />
		            <ImageView fx:id="star1" fitHeight="99.0" fitWidth="106.0" layoutX="119.0" layoutY="112.0" pickOnBounds="true" preserveRatio="true">
		               <image>
		                  <Image url="@../../images/star.png" />
		               </image>
		            </ImageView>
		         </children>
		      </Pane>
		      <Pane fx:id="pane2" layoutX="98.0" layoutY="204.0" prefHeight="399.0" prefWidth="404.0" visible="false">
		         <children>
		            <ImageView fx:id="star2" fitHeight="99.0" fitWidth="106.0" layoutX="167.0" layoutY="143.0" pickOnBounds="true" preserveRatio="true">
		               <image>
		                  <Image url="@../../images/star.png" />
		               </image>
		            </ImageView>
		            <Rectangle fx:id="blue2" arcHeight="5.0" arcWidth="5.0" fill="#32dbf0" height="30.0" layoutX="-33.0" layoutY="102.0" rotate="135.0" stroke="#32dbf0" strokeType="INSIDE" width="300.0" />
		            <Rectangle fx:id="pink2" arcHeight="5.0" arcWidth="5.0" fill="#ff0181" height="30.0" layoutX="156.0" layoutY="102.0" rotate="45.0" stroke="#ff0181" strokeType="INSIDE" width="300.0" />
		            <Rectangle fx:id="yellow2" arcHeight="5.0" arcWidth="5.0" fill="#e2ff00" height="30.0" layoutX="156.0" layoutY="294.0" rotate="135.0" stroke="#e2ff00" strokeType="INSIDE" width="300.0" />
		            <Rectangle fx:id="purple2" arcHeight="5.0" arcWidth="5.0" fill="#900dff" height="30.0" layoutX="-33.0" layoutY="294.0" rotate="45.0" stroke="#900dff" strokeType="INSIDE" width="300.0" />
		         </children>
		      </Pane>
		      <Button fx:id="scoreButton" layoutX="27.0" layoutY="699.0" mnemonicParsing="false" onAction="#goBack" prefHeight="60.0" prefWidth="133.0" text="SCORE: 0">
		         <font>
		            <Font name="System Bold" size="19.0" />
		         </font>
		         <effect>
		            <Lighting>
		               <bumpInput>
		                  <Shadow />
		               </bumpInput>
		               <light>
		                  <Light.Distant color="#ffd23c" />
		               </light>
		            </Lighting>
		         </effect>
		         <textFill>
		            <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		               <stops>
		                  <Stop color="#b06b6b" />
		                  <Stop color="#f81212" offset="1.0" />
		               </stops>
		            </RadialGradient>
		         </textFill>
		      </Button>
		      <Button fx:id="saveGameButton" layoutX="430.0" layoutY="703.0" mnemonicParsing="false" onAction="#saveGame" prefHeight="51.0" prefWidth="144.0" text="SAVE GAME">
		         <font>
		            <Font name="System Bold" size="19.0" />
		         </font>
		         <effect>
		            <Lighting>
		               <bumpInput>
		                  <Shadow />
		               </bumpInput>
		               <light>
		                  <Light.Distant color="#ffd23c" />
		               </light>
		            </Lighting>
		         </effect>
		         <textFill>
		            <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		               <stops>
		                  <Stop color="#b06b6b" />
		                  <Stop color="#f81212" offset="1.0" />
		               </stops>
		            </RadialGradient>
		         </textFill>
		      </Button>
		      <Pane fx:id="gameOverPane" layoutX="71.0" layoutY="145.0" prefHeight="437.0" prefWidth="459.0" style="-fx-background-color: maroon;" visible="false">
		         <children>
		            <Label layoutX="125.0" layoutY="8.0" prefHeight="88.0" prefWidth="232.0" text="GAME OVER!!!">
		               <font>
		                  <Font name="System Bold" size="32.0" />
		               </font>
		               <textFill>
		                  <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		                     <stops>
		                        <Stop color="#fcf15e" />
		                        <Stop color="#dac227" offset="1.0" />
		                     </stops>
		                  </RadialGradient>
		               </textFill>
		            </Label>
		            <TextArea fx:id="scoreTextArea" editable="false" layoutX="83.0" layoutY="115.0" prefHeight="51.0" prefWidth="317.0" style="-fx-background-color: black; -fx-background-color: black;" text="Stars you have: &#10;&#10;" wrapText="true">
		               <font>
		                  <Font name="System Bold" size="24.0" />
		               </font>
		               <effect>
		                  <SepiaTone />
		               </effect>
		            </TextArea>
		            <Button fx:id="goBackButton" layoutX="93.0" layoutY="236.0" mnemonicParsing="false" onAction="#gogoBack" prefHeight="51.0" prefWidth="296.0" text="BACK TO MAIN MENU">
		               <font>
		                  <Font name="System Bold" size="24.0" />
		               </font>
		               <effect>
		                  <Lighting>
		                     <bumpInput>
		                        <Shadow />
		                     </bumpInput>
		                     <light>
		                        <Light.Distant color="#ffd23c" />
		                     </light>
		                  </Lighting>
		               </effect>
		               <textFill>
		                  <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		                     <stops>
		                        <Stop color="#b06b6b" />
		                        <Stop color="#f81212" offset="1.0" />
		                     </stops>
		                  </RadialGradient>
		               </textFill>
		            </Button>
		            <Button fx:id="resurrectButton" layoutX="116.0" layoutY="324.0" mnemonicParsing="false" onAction="#resurrect" prefHeight="51.0" prefWidth="250.0" text="RESURRECT ME ">
		               <font>
		                  <Font name="System Bold" size="24.0" />
		               </font>
		               <effect>
		                  <Lighting>
		                     <bumpInput>
		                        <Shadow />
		                     </bumpInput>
		                     <light>
		                        <Light.Distant color="#ffd23c" />
		                     </light>
		                  </Lighting>
		               </effect>
		               <textFill>
		                  <RadialGradient centerX="0.5" centerY="0.5" radius="0.5">
		                     <stops>
		                        <Stop color="#b06b6b" />
		                        <Stop color="#f81212" offset="1.0" />
		                     </stops>
		                  </RadialGradient>
		               </textFill>
		            </Button>
		         </children>
		      </Pane>
		      
		   </children>
		</AnchorPane> */

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
