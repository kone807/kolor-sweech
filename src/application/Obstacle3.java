package application;

import java.io.Serializable;

public class Obstacle3 extends Obstacle implements Serializable{
	private static final long serialVersionUID = 35L;
	protected String name;
	
	public Obstacle3()
	{
		super();
		this.name="cross";
	}
}
