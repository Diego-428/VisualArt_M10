/*
Diego Torres-Ramos
CSCI 3725
The Ball class consists of traits that define the circle at every frame.
An example of this was be the new x and y positions, color and diameter of the ball.
*/
class Ball{
	// attributes
  int x;
  int y;
  int diameter;
  int xSpeed;
  int ySpeed;
	// How much red, green, and blue this Bubble has.
	private float myRed;
	private float myGreen;
	private float myBlue;
	int[] positionXTracker;
	int[] positionYTracker;
	// constructor
	public Ball(int x, int y, int diameter, int xSpeed, int ySpeed,
						 float red, float blue, float green){
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.myRed = red;
		this.myBlue = blue;
		this.myGreen = green;
		positionXTracker = new int[frameLimit];
		positionYTracker = new int[frameLimit];
	}
	
	public void changeColor(){
		myRed = random(0,255);
		myBlue = random(0,255);
		myGreen = random(0,255);
	}
	
	// setters and getters
	public void setX(x){
		this.x = x;
	}
	
	public void setY(y){
		this.y = y;
	}
	
	public void setDiameter(diameter){
		this.diameter = diameter;
	}
	
	public void setXSpeed(xSpeed){
		this.xSpeed = xSpeed;
	}	
	
	public void setYSpeed(ySpeed){
		this.ySpeed = ySpeed;
	}
	
	public void setRed(newRed){
		this.myRed = newRed;
	}
	
	public void setBlue(newBlue){
		this.myBlue = newBlue;
	}
	
	public void setGreen(newGreen){
		this.myGreen = newGreen;
	}
}