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
// Make the course blocks - done
// Move the course blocks - done
// Create pre-generated mini-obstacle courses - in progress
// Load the obstacle course before the game starts (add loading screen maybe?) - in progress, 40% complete
// Add audio?

// Make the player rotate when jumping (like in Geometry Dash)

// Current Issues:

// I can't make the preset appear in the game. The method runs though - done
// Need to figure out whether I should use one obstacle arraylist for both triangle and squares or stick with the two. - done
// I need to fix the jumping problem when on a block
// Triangle's intersect function never returns true


public class GeometryDash {
	private int WIDTH = 1000, HEIGHT = 700, PLAYERWIDTH = 50, PLAYERHEIGHT = 50, DIFFICULTY = 30;
	// list of obstacles
	private ArrayList<GeometryObject> obstacles = new ArrayList<GeometryObject>();

	//DONT CHANGE
	private GeometryObject player;
	private GeometryObject backgroundImg;
	private int backgroundSpeed = -7, gravity = 1, defaultPlayerSpeed = -15 , playerSpeed = defaultPlayerSpeed, timerCount = 150, groundHeight = 472, obstacleCount = 0, presetWidth = 0, obstacleHeight = 0;
	private boolean lost = false, won = false, paused = true, jumping = false, spawn = true;
	// don't forget, groundHeight is actually 472 pixels above the ground
	public void move() {
		if (player.y < groundHeight - obstacleHeight) {
			playerSpeed += gravity;
			player.moveY(playerSpeed);
		}
	
		if (player.y > groundHeight - obstacleHeight) {
			player.y = groundHeight - obstacleHeight;
			playerSpeed = defaultPlayerSpeed;
			jumping = false;
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).moveX(backgroundSpeed);
		}
	}

	public void checkCollisions() {
		boolean hitSomething = false;
		
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).x + PLAYERWIDTH <= 0) {
				obstacles.remove(i);
				continue;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 1) {
				lost = true;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 0) {
				// I subtracted by playerSpeed since the player y value is not actually the obstacle's y value when it intersects, but rather a little below the obstacle
				if(player.y + player.height - playerSpeed <= obstacles.get(i).y) {
						obstacleHeight = groundHeight + player.height - obstacles.get(i).y;
						player.y = obstacles.get(i).y - player.height;
						jumping = false;
						hitSomething = true;
				} else {
					lost = true;
				}
			}

			
		
			
			// temporary win condition
			if (player.x + player.width > obstacles.get(obstacles.size() - 1).x) {
				won = true;
			}
		}
		if (!hitSomething) {
			obstacleHeight = 0;
		}
		
	}
	public void loadPreset1() {
		// loads obstacle preset1
		obstacles.add(new TriangleObstacle((int)WIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 2 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 6 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 6 * PLAYERWIDTH + presetWidth, groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH + presetWidth, groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
	}
	
	public void loadPreset2() {
		obstacles.add(new GeometryObject((int)WIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 3 * PLAYERWIDTH + presetWidth, groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 6 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 8 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 9 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 11 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 11 * PLAYERWIDTH + presetWidth, groundHeight - 3 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
	}
	public void setup() {
		backgroundImg = new GeometryObject(0, 0, WIDTH, HEIGHT, "Images/GeometryDashBackground.jpeg");
		player = new GeometryObject((int)(WIDTH/4), groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/Cube.png");
	
	}
	public void spawnObstacles() {
		
		if (obstacles.size() < DIFFICULTY) {
			double random = (Math.random() * 100) + 1;
			//System.out.println(random);
			presetWidth += 6;
			if (random > 1 && random < 1.8 && timerCount > 150) {
				loadPreset1();
				timerCount = 0;
			}
			if (random > 1.8 && random < 2.3 && timerCount > 150) {
				loadPreset2();
				timerCount = 0;
			}
			timerCount++;
		}
		else {
			spawn = false;
			paused = !paused;
		}
	} 
	
	public void draw(Graphics g) {
		backgroundImg.draw(g);
		if (!lost && !won) {
			player.draw(g);
			for (int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).draw(g);
			}
		}
		int progress = obstacles.get(obstacles.size()-1).x - player.x - player.width;
		g.drawRect(WIDTH/6, HEIGHT/12, 2*WIDTH/3, HEIGHT/12);
		g.fillRect(WIDTH/6, HEIGHT/12, (player.x + player.width)/progress * 2*WIDTH/3, HEIGHT/12);
		//System.out.println(obstacles.get(obstacles.size()-1).x/progress);
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
				paused = !paused;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {			
			if (e.getKeyChar() == KeyEvent.VK_SPACE && jumping == false) {
				playerSpeed = defaultPlayerSpeed;
				jumping = true;
				obstacleHeight = 0;
				player.moveY(playerSpeed);
				playerSpeed += gravity;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	});
	frame.add(canvas);
	frame.setVisible(true);
	while (spawn == true) {
		spawnObstacles();
	}
	while (true) {
		if (!paused) {
			move();
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
