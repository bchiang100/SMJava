package blackjack;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class card extends Rectangle{
	private int x;
	private int y;
	Image img;
	public card (int x, int y, int w, int h, String imgName){
		super(x, y , w, h);
		try {
			img = ImageIO.read(new File(imgName)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Image file not found");
		}
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}
