package homework;

import java.awt.Color;

public class BouncingBall extends Ball{
	public BouncingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move() {
		super.move();
		if (super.getX() >= WIDTH || super.getX() <= 0) {
			super.setXSpeed(super.getXSpeed() * -1);
		}
		if (super.getY() >= HEIGHT || super.getY() <= 0) {
			super.setYSpeed(super.getYSpeed() * -1);
		}
	}
}
