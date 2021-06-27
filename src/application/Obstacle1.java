package application;

import java.io.Serializable;

public class Obstacle1 extends Obstacle implements Serializable{
	private static final long serialVersionUID = 33L;
	protected String name;
	
	public Obstacle1()
	{
		super();
		this.name="circle";
	}
}
