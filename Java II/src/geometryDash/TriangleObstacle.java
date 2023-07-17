package geometryDash;

import java.awt.Graphics;
import java.awt.Rectangle;

public class TriangleObstacle extends GeometryObject{
	Rectangle r1 = new Rectangle(x, y + height - (int)(height/4), width, (int)(height/4));
	Rectangle r2 = new Rectangle(x + (int)(width/2) - (int)(0.5 * width/5), y + 10, (int)(width/5), (int)(3*height/4));
	
	public TriangleObstacle(int x, int y, int w, int h, String imgName) {
		super(x, y, w, h, imgName);
	}
	public void moveX(int dX) {
		x += dX;
		r1.x += dX;
		r2.x += dX;
	}
	
	public boolean intersects(Rectangle player) {
		return (r1.intersects(player) || r2.intersects(player));
	}

	public int getType() {
		return 1;
	}
}