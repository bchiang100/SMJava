package spaceInvaders;

import java.awt.Rectangle;


public class Laser extends Rectangle{
	public Laser(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void moveY(int laserSpeed) {
		// moves down, while other method moves relative to alien (in main class)
	}
	public void draw() {
		// draws the lasers, both alien and player
	}
	public double getY() {
		return y;
	}
}
