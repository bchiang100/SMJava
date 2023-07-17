package classwork;
import java.awt.Color;
import java.awt.Graphics;

public class Block {
	private int x;
	private int y;
	private Color color;
	private int speed;
	private int blockWidth = 10;
	private int blockHeight = 10;
	

	public Block(int x, int y, Color color, int speed) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.speed = speed;
	}
	
	public int getY() {
		return y;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, blockWidth, blockHeight);
	}
	public void move() {
		y+=speed;
		y+=1;
	}
}
