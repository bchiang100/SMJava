package homework;

import java.awt.Color;

public class CirclePathBall extends BouncingBall{
	public CirclePathBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	int count = 0;
	public void move() {
		super.move();
		super.setX((int)(50 * Math.cos(count/(5 * 3.14)) + 200));
		super.setY((int)(50 * Math.sin(count/(5 * 3.14)) + 200));
		count++;
	}
}
