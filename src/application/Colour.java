package application;


import java.io.Serializable;
import java.util.*;

import javafx.scene.paint.Color;

//color codes
//green - #272727
//yellow - #FAE100
//violet - #900DFF
//pink - #FF0181
//Turquoise - #32DBF0

public class Colour implements Serializable{
	protected ArrayList<Color> pallete = new ArrayList<Color>();
	
	public Colour()
	{
		pallete.add(Color.web("#ff0181"));
		pallete.add(Color.web("#900dff"));
		pallete.add(Color.web("#e2ff00"));
		pallete.add(Color.web("#32dbf0"));
	}
	
	Color getNewColor(Color c)
	{
		Random rand = new Random();
		int r = rand.nextInt(4);
		while(c.toString().equals(pallete.get(r).toString()))
			r=rand.nextInt(4);
		
		return pallete.get(r);
	}
}
