package wordle;
import java.awt.Color;
import java.awt.Graphics;

public class grid {
	private int x;
	private int y;
	private Color color;
	
	private int blockWidth = 50;
	private int blockHeight = 50;
	private Color innerColor = Color.white;

	public grid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public void setColor(Color c) {
		innerColor = c;
	}
	public void draw(Graphics g) {
		//add green set 
		
		g.setColor(color);
		g.drawRect(x, y, blockWidth, blockHeight);
		g.setColor(innerColor);
		g.fillRect(x + 3, y + 3, blockWidth - 5, blockHeight- 5);
	}
}
