/*
Diego Torres-Ramos
CSCI 3725
This driver file dictates how user input is handled at every frame.
It also handles the ball bounce and color changes.
*/
List<Ball> storage = new ArrayList();
// frame size
final int frameLength = 500;
final int frameWidth = 500;
// variables for position tracking
final int frameLimit = 60;
// speed in which the balls move
int velocityX = 5;
int velocityY = 3;
// keep track of the current backgorund color, used to omit the trail of balls drawn
int[] currentColorCombination = new int[3];

void setup() {
  size(frameLength, frameWidth);
  // Draw a semi-transparent background to create a trail effect
  background(0, 0, 0, 2);
}

// called at every frame
void draw() { 
	background(currentColorCombination[0], currentColorCombination[1],
						 currentColorCombination[2]);
	for( int i = 0; i < storage.size(); i++ ){
		Ball ball = storage.get(i);
		// Update ball position
		ball.setX(ball.x + ball.xSpeed);
		ball.setY(ball.y + ball.ySpeed);
		// Bounce off walls
		if( isColliding(ball) ){
			ball.setXSpeed(ball.xSpeed * -1);
			ball.setYSpeed(ball.ySpeed * -1);
		}
		// bounce off left or right wall
		if (ball.x < 0 || ball.x > frameWidth) {
			ball.setXSpeed(ball.xSpeed * -1);
			ball.changeColor();
			currentColorCombination = newRGB();
			background(currentColorCombination[0], currentColorCombination[1],
								 currentColorCombination[2]);
		}
		// bounce off top or bottom wall
		if (ball.y < 0 || ball.y > frameLength) {
			ball.setYSpeed(ball.ySpeed * -1);
			ball.changeColor();
			currentColorCombination = newRGB();
			background(currentColorCombination[0], currentColorCombination[1],
								 currentColorCombination[2]);
		}
		if( keyCode == UP ){
			ball.xSpeed = 0;
			ball.ySpeed = 0;
			display(ball);
		}
		else{
			// Draw the bouncing ball
			display(ball);
		}	
	}
}

void display(currentBall) {
	// fill the ball with the specified color
	fill(currentBall.myRed, currentBall.myGreen, currentBall.myBlue);
	// Draws an ellipse on the screen to represent our Bubble.
	ellipse(currentBall.x, currentBall.y, currentBall.diameter, currentBall.diameter);
  // Cycle through the array, using a different entry on each frame. 
  // Using % to circulate and recycle through array values
  int trailingBallPosition = frameCount % frameLimit;
  currentBall.positionXTracker[trailingBallPosition] = currentBall.x;
  currentBall.positionYTracker[trailingBallPosition] = currentBall.y;
  // render the ball trail of varying size
  for (int i = 0; i < frameLimit; i++) {
    // trailingBallPosition+1 is the smallest (the oldest in the array)
    int index = (trailingBallPosition+1 + i) % frameLimit;
    ellipse(currentBall.positionXTracker[index], currentBall.positionYTracker[index], i, i);
  }
}

// Function to check collision between two circles
boolean isColliding(Ball ball) {
	for(int i = 0; i < storage.size(); i++ ){
		Ball currentBall = storage.get(i);
		if( ball != currentBall ){
			float distance = dist(ball.x, ball.y, currentBall.x, currentBall.y);
			if ( distance <= ((ball.diameter / 2) + (currentBall.diameter / 2)) ){
					return true;
			}			
		}
	}
	return false;
}

// spawns a new ball wherever the mouse is clicked
void mouseClicked(){
	storage.add( new Ball( mouseX, mouseY, 5, 5, 3, 10, 10, 10) );
}

int[] newRGB(){
	// return a random color (as a list)
	return new int[3] {random(255), random(255), random(255)};
}
