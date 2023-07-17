package homework;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class FallingBlocks extends JPanel {
	Random r = new Random();
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;
	private int squareSide = 10;
	private int speed;
	private int xCoord[] = new int[NUMBLOCKS];
	private int yCoord[] = new int[NUMBLOCKS];
	int i;
	int j;

	int speedArray[] = {2,3,6, 8, 9};
	//int xCoordArray[] = {20, 50, 100, 130, 140, 160, 180, 300, 400, 500, 676, 760};
	//private int rNumHeight = r.nextInt(HEIGHT);
	// instance variables (what kind of data structure should we use?)
	
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		//setting each individual square's x position and speed to be different (for some reason the speed is the same for all the squares and I don't know why)
		for (i = 0; i<NUMBLOCKS-1; i++) {
			xCoord[i] = (int)(Math.random() * 700 + 50);
			
		}
		for (j = 0; j<NUMBLOCKS-1; j++) {
			speed = speedArray[(int)(Math.random() * speedArray.length)];
			//yCoord[j]+=speed;
			System.out.println(speed);
			
		}
	}
	
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		//gives the squares speed
		yCoord[j]+=speed;
		//if the y coordinate of the squares reach the bottom of the screen then it will automatically spawn back in y = 0
		if (yCoord[j]==HEIGHT) {
			yCoord[j] = 0;
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		g.setColor(Color.blue);
		
		//creating NUMBLOCKS squares
		for (int i = 0; i<NUMBLOCKS-1; i++) {
			g.fillRect(xCoord[i], yCoord[j] , squareSide, squareSide);
		}

	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocks() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocks();
	}

}