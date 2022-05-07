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
// Make the course blocks
// Move the course blocks
// Make the player rotate when jumping (like in Geometry Dash)

public class GeometryDash {
	private int WIDTH = 1000, HEIGHT = 700, PLAYERWIDTH = 50, PLAYERHEIGHT = 50;
	private boolean lost = false, won = false, paused = true, jumping = false;
	
	// list of obstacles
	private ArrayList<GeometryObject> obstacles = new ArrayList<GeometryObject>();
	
	//DONT CHANGE
	private GeometryObject player;
	private int backgroundSpeed = 0, gravity = 2, defaultPlayerSpeed = -20, playerSpeed = defaultPlayerSpeed, numObstacles = 20, timerCount = 50;
	public void move() {
		if (player.y < (HEIGHT/2 - PLAYERHEIGHT/2) && jumping == false) {
			playerSpeed += gravity;
			player.moveY(playerSpeed);
		}
		if (player.y > (HEIGHT/2 - PLAYERHEIGHT/2) + 1) {
			player.y = (HEIGHT/2 - PLAYERHEIGHT/2);
			playerSpeed = defaultPlayerSpeed;
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).moveX(-2);
		}
	}
	int count = 0;
	public void jump() {
		// Problem: I can't get the cube to move at a quadratic path (it won't move at all)
		if (jumping == true) {
		jumping = true;
		playerSpeed += gravity;
		player.moveY(playerSpeed);
		}
	}
	public void checkCollisions() {
		
	}
	public void setup() {
		player = new GeometryObject((int)(WIDTH/4), (int)(HEIGHT/2 - PLAYERHEIGHT/2), PLAYERWIDTH, PLAYERHEIGHT, "Images/Cube.png");
		
	}
	public void spawnObstacles() {
		double random = (Math.random() * 100) + 1;
		int obstacleCount = 0;
		if (random > 98.5 & timerCount >= 75) {
			obstacles.add(new GeometryObject((int)WIDTH + 1, (int)(HEIGHT/2 - PLAYERHEIGHT/2), PLAYERWIDTH, PLAYERHEIGHT, "Images/Obstacle.png"));
			obstacleCount++;
			timerCount = 0;
		}
		timerCount++;
	}
	public void draw(Graphics g) {
		Color backgroundColor = new Color (51, 51, 255);
		g.setColor(backgroundColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		player.draw(g);
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
