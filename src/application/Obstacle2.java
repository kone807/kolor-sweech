package application;

import java.io.Serializable;

public class Obstacle2 extends Obstacle implements Serializable{
	private static final long serialVersionUID = 34L;
	protected String name;
	
	public Obstacle2()
	{
		super();
		this.name="diamond";
	}
}
