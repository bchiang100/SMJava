package geometryDash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

// To-do List:

// Draw the player - done
// Make the player jump in a quadratic path - done
// Make the course blocks - 50% done
// Move the course blocks - pretty much done
// Create pre-generated mini-obstacle courses

// Make the player rotate when jumping (like in Geometry Dash)

// Current Issues:

// I can't make the preset appear in the game. The method runs though
// Need to figure out whether I should use one obstacle arraylist for both triangle and squares or stick with the two.

public class GeometryDash {
	private int WIDTH = 1000, HEIGHT = 700, PLAYERWIDTH = 50, PLAYERHEIGHT = 50;
	private boolean lost = false, won = false, paused = true, jumping = false;
	
	// list of obstacles
	private ArrayList<GeometryObject> obstacles = new ArrayList<GeometryObject>();
	private GeometryObject[] preset1 = new GeometryObject[8];
	//DONT CHANGE
	private GeometryObject player;
	private GeometryObject backgroundImg;
	private int backgroundSpeed = -10, gravity = 3, defaultPlayerSpeed = -40, playerSpeed = defaultPlayerSpeed, numObstacles = 20, timerCount = 0, groundHeight = (int)(HEIGHT * 0.675), obstacleCount = 0;;
	public void move() {
		if (player.y < groundHeight && jumping == false) {
			playerSpeed += gravity;
			player.moveY(playerSpeed);
		}
		if (player.y > groundHeight + 1) {
			player.y = groundHeight;
			playerSpeed = defaultPlayerSpeed;
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).moveX(backgroundSpeed);
		}
	}
	int count = 0;
	public void jump() {
		if (jumping == true) {
			playerSpeed += gravity;
			player.moveY(playerSpeed);
		}
	}
	public void checkCollisions() {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).x + PLAYERWIDTH <= 0) {
				obstacles.remove(i);
				continue;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 2) {
				lost = true;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 1) {
				if (player.x >= obstacles.get(i).x) {
					player.y = groundHeight - obstacles.get(i).height;
				} else {
					lost = true;
				}
			}
		}
	}
	public void loadPreset1() {
		// loads obstacle preset1
		obstacles.add(new GeometryObject((int)WIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.jpg", 2));
		obstacles.add(new GeometryObject((int)WIDTH + PLAYERWIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.jpg", 2));
		obstacles.add(new GeometryObject((int)WIDTH + 2 * PLAYERWIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png", 1));
		obstacles.add(new GeometryObject((int)WIDTH + 6 * PLAYERWIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png", 1));
		obstacles.add(new GeometryObject((int)WIDTH + 6 * PLAYERWIDTH, groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png", 1));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png", 1));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH, groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png", 1));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png", 1));
	}
	
	public void setup() {
		backgroundImg = new GeometryObject(0, 0, WIDTH, HEIGHT, "Images/GeometryDashBackground.jpeg", 0);
		player = new GeometryObject((int)(WIDTH/4), groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/Cube.png", 1);
	
	}
	public void spawnObstacles() {
		double random = (Math.random() * 100) + 1;
//		if (random > 98.5 && timerCount >= 50 && obstacleCount < 3) {
//			obstacles.add(new GeometryObject((int)WIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.jpg", 2));
//			obstacleCount++;
//			timerCount = 0;
//			System.out.println("obstacle count is " + obstacleCount + " and timercount is " + timerCount);
//		}
		if (random > 99.8 && timerCount >= 100) {
			System.out.println("it worked");
			loadPreset1();
			obstacleCount = 0;
		}
		timerCount++;
	} 
	public void drawObstacles(Graphics g) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
	}
	public void draw(Graphics g) {
		backgroundImg.draw(g);
		if (!lost && !won) {
			player.draw(g);
			for (int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).draw(g);
			}
			// it wont draw for some reason
			for (int i = 0; i < preset1.length; i++) {
				if (preset1[i] != null) {
					preset1[i].draw(g);
				}
			}
		}
		if (lost) {
			g.setColor(Color.white);
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		}
		// prints "you win" if you win
		if (won) {
			g.setColor(Color.white);
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
		}
	}
	
	
	
	// RUNNER CODE -- DONT TOUCH UNLESS ABSOLUTELY NECSESSARY
	public GeometryDash() {
	setup();
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel canvas = new JPanel() {
		public void paint(Graphics g) {draw(g);}
	};
	frame.addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {				
			if (e.getKeyChar() == 'p') {
				paused = false;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {			
			if (e.getKeyChar() == KeyEvent.VK_SPACE) {
				jumping = true;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_SPACE) {
				jumping = false;
			}
		}
		
	});
	frame.add(canvas);
	frame.setVisible(true);
	
	while (true) {
		if (!paused) {
			jump();
			move();
			spawnObstacles();
			checkCollisions();
			frame.getContentPane().repaint();
		}
		try {Thread.sleep(20);} 
		catch (InterruptedException e) {}
	}
}



public static void main(String[] args) {
	new GeometryDash();
	}
}
