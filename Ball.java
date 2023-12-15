/*
Name: Diego Torres-Ramos
CSCI 3725
Ball class defines a the circle that moves and bounces around the screen.
It consists of attributes that defines its traits like diameter and current location.
Another trait it has is red, green, and blue color palette to generate a random 
color for the ball when it bounces off the walls.
*/
class Ball{
	// x and y are the object's current coordinates
  int x;
  int y;
	// diameter is the objects size
  int diameter;
	// velocity the in which the object moves
  int xSpeed;
  int ySpeed;
	// How much red, green, and blue this Bubble has.
	private float myRed;
	private float myGreen;
	private float myBlue;
	// used for rendering the fading trail
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
	
	// method used for redefining the ball color
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