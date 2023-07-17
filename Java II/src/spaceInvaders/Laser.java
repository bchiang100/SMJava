package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Laser extends Rectangle{
	Color color;
	public Laser(int x, int y, int w, int h, Color c) {
		super(x, y, w, h);
		color = c;
	}
	
	public void moveY(int LASERSPEED) {
		y += LASERSPEED;
	}
	public void draw(Graphics g) {
		// draws the lasers, both alien and player
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	public double getY() {
		return y;
	}
	public double getX() {
		return x;
	}
	public int getW() {
		return width;
	}
	public int getH() {
		return height;
	}
}
