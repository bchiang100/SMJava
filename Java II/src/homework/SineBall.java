package homework;

import java.awt.Color;

public class SineBall extends BouncingBall{
	public SineBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move() {
		super.move();
		super.setY((int)(Math.sin(super.getX()/ (5 * 3.14)) * 30 + 200));
	}
}
