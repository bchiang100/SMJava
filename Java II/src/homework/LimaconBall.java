package homework;

import java.awt.Color;

public class LimaconBall extends BouncingBall{
	public LimaconBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	int count = 0;
	public void move() {
		super.move();
		super.setX((int)(50 * Math.cos(count/(5 * 3.14))) * (int)Math.cos(count) + 200);
		super.setY((int)(50 * Math.sin(count/(5 * 3.14))) * (int)Math.cos(count) + 200);
		count++;
	}
}
