Ball ball = new Ball(50, 50, 30, 5, 3, 10, 10, 10);
// frame size
final int frameLength = 500;
final int frameWidth = 500;
// variables for position tracking
final int frameLimit = 60;
int[] positionXTracker = new int[frameLimit];
int[] positionYTracker = new int[frameLimit];
// keep track of the current backgorund color, used to omit the trail of balls drawn
int[] currentColorCombination = new int[3];

void setup() {
  size(frameLength, frameWidth);
  // Draw a semi-transparent background to create a trail effect
  background(0, 0, 0, 2);
}

void draw() { 
	background(currentColorCombination[0], currentColorCombination[1],
						 currentColorCombination[2]);
  // Update ball position
  ball.setX(ball.x + ball.xSpeed);
  ball.setY(ball.y + ball.ySpeed);
  // Bounce off walls
  if (ball.x < 0 || ball.x > frameWidth) {
    ball.setXSpeed(ball.xSpeed * -1);
		ball.setDiameter(ball.diameter);
		ball.changeColor();
		currentColorCombination = newRGB();
		background(currentColorCombination[0], currentColorCombination[1],
							 currentColorCombination[2]);
  }
  if (ball.y < 0 || ball.y > frameLength) {
    ball.setYSpeed(ball.ySpeed * -1);
		ball.setDiameter(ball.diameter);
		ball.changeColor();
		currentColorCombination = newRGB();
		background(currentColorCombination[0], currentColorCombination[1],
							 currentColorCombination[2]);
  }
  // Draw the bouncing ball
  display(ball);
}

void display(currentBall) {
	// fill the ball with the specified color
	fill(currentBall.myRed, currentBall.myGreen, currentBall.myBlue);
	// Draws an ellipse on the screen to represent our Bubble.
	ellipse(currentBall.x, currentBall.y, currentBall.diameter, currentBall.diameter);
  // Cycle through the array, using a different entry on each frame. 
  // Using % to circulate and recycle through array values
  int trailingBallPosition = frameCount % frameLimit;
  positionXTracker[trailingBallPosition] = currentBall.x;
  positionYTracker[trailingBallPosition] = currentBall.y;
  // render the ball trail of varying size
  for (int i = 0; i < frameLimit; i++) {
    // trailingBallPosition+1 is the smallest (the oldest in the array)
    int index = (trailingBallPosition+1 + i) % frameLimit;
    ellipse(positionXTracker[index], positionYTracker[index], i, i);
  }
}

int[] newRGB(){
	// return a random color (as a list)
	return new int[3] {random(255), random(255), random(255)};
}
