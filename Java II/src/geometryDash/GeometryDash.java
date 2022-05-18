package geometryDash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
	private int WIDTH = 1000, HEIGHT = 700, PLAYERWIDTH = 50, PLAYERHEIGHT = 50, BOOSTERHEIGHT = (int)(0.25 * PLAYERHEIGHT), DIFFICULTY = 50;
	// list of obstacles
	private ArrayList<GeometryObject> obstacles = new ArrayList<GeometryObject>();

	//DONT CHANGE
	private double progress;
	private GeometryObject player;
	private GeometryObject backgroundImg;
	private int backgroundSpeed = -7, gravity = 1, defaultPlayerSpeed = -15 , playerSpeed = defaultPlayerSpeed, boosterSpeed = -25, timerCount = 150, groundHeight = 472, obstacleCount = 0, presetWidth = 0, obstacleHeight = 0;
	private boolean lost = false, won = false, paused = true, jumping = false, spawn = true, spacePressed = false;
	public void move() {
		if (player.x < (int)(WIDTH/4)) {
			player.moveX(7);
		}
		if (player.y < groundHeight - obstacleHeight) {
			playerSpeed += gravity;
			player.moveY(playerSpeed);
		}

		if (player.y > groundHeight - obstacleHeight) {
			player.y = groundHeight - obstacleHeight;
			playerSpeed = defaultPlayerSpeed;
			jumping = false;
		}
		if (obstacles.size() > 0) {
			for (int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).moveX(backgroundSpeed);
			}
		}
	}

	public void checkCollisions() {
		boolean hitSomething = false;
		
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).x + PLAYERWIDTH <= 0) {
				obstacles.remove(i);
				if (i != 0) {
					i--;
				}
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
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 2) {
				playerSpeed = boosterSpeed;
				jump();
			}
			if (obstacles.get(i).intersects(player) && spacePressed && obstacles.get(i).getType() == 3) {
				playerSpeed = defaultPlayerSpeed;
				jump();
			}
		
			
			// temporary win condition
			if (player.x > obstacles.get(obstacles.size() - 1).x) {
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
		
		//obstacles.add(new Booster((int)WIDTH + 13 * PLAYERWIDTH + presetWidth, groundHeight + (PLAYERHEIGHT- BOOSTERHEIGHT), PLAYERWIDTH, BOOSTERHEIGHT, "Images/OrangeRectangle.png"));
		//obstacles.add(new JumpRing((int)(WIDTH + 18 * PLAYERWIDTH + presetWidth), groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/JumpRing.png"));
	}
	
	public void loadPreset2() {
		obstacles.add(new GeometryObject((int)WIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 4 * PLAYERWIDTH + presetWidth, groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 7 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 10 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 11 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 12 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 13 * PLAYERWIDTH + presetWidth, groundHeight - 2 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 13 * PLAYERWIDTH + presetWidth, groundHeight - 3 * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 13 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		
	}
	
	public void loadPreset3() {
		obstacles.add(new GeometryObject((int)WIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + PLAYERWIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 2 * PLAYERWIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 3 * PLAYERWIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 4 * PLAYERWIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 5 * PLAYERWIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new GeometryObject((int)WIDTH + 6 * PLAYERWIDTH + presetWidth, groundHeight - 4 * PLAYERHEIGHT + PLAYERHEIGHT / 2, PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		obstacles.add(new Booster((int)WIDTH + 1 * PLAYERWIDTH + presetWidth, groundHeight + (PLAYERHEIGHT- BOOSTERHEIGHT), PLAYERWIDTH, BOOSTERHEIGHT, "Images/OrangeRectangle.png"));
		obstacles.add(new Booster((int)WIDTH + 5 * PLAYERWIDTH + presetWidth, groundHeight + (PLAYERHEIGHT- BOOSTERHEIGHT), PLAYERWIDTH, BOOSTERHEIGHT, "Images/OrangeRectangle.png"));
		obstacles.add(new JumpRing((int)(WIDTH + 11 * PLAYERWIDTH + presetWidth), groundHeight - PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT, "Images/JumpRing.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 9 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 10 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 11 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 12 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		obstacles.add(new TriangleObstacle((int)WIDTH + 13 * PLAYERWIDTH + presetWidth, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
	}
	public void loadPreset4() {
		
	}
	public void loadPreset5() {
		
	}
	
	public void setup() {
		backgroundImg = new GeometryObject(0, 0, WIDTH, HEIGHT, "Images/GeometryDashBackground.jpeg");
		player = new GeometryObject(4 * -PLAYERWIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/Cube.png");
	}
	public void spawnObstacles() {
		if (obstacles.size() < DIFFICULTY) {
			double random = (Math.random() * 100) + 1;
			//System.out.println(random);
			presetWidth += 6;
			if (random > 1 && random < 1.8 && timerCount > 200) {
				loadPreset1();
				timerCount = 0;
			}
			if (random > 1.8 && random < 2.4 && timerCount > 200) {
				loadPreset2();
				timerCount = 0;
			}
			if (random > 2.4 && random < 6 && timerCount > 200) {
				loadPreset3();
				timerCount = 0;
			}
			timerCount++;
		}
		else {
			spawn = false;
			progress = obstacles.get(obstacles.size()-1).x;
			//maybe add a wall in the ending
			//obstacles.add(new Rectangle(obstacles.get(obstacles.size()-1).x + 200), 0, 20, HEIGHT)));
			paused = !paused;
		}
	} 
	
	public void jump() {
		if (jumping == false) {
			if (playerSpeed != boosterSpeed) {
				playerSpeed = defaultPlayerSpeed;
			}
			jumping = true;
			obstacleHeight = 0;
			player.moveY(playerSpeed);
			playerSpeed += gravity;
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
		System.out.println(progress);
		System.out.println((progress - obstacles.get(obstacles.size()-1).x + 5 * PLAYERWIDTH));
		g.drawRect(WIDTH/6, HEIGHT/12, 2*WIDTH/3, HEIGHT/36);
		
		//make sure its not empty
		if ((progress - obstacles.get(obstacles.size()-1).x)/progress <= 2*WIDTH/3) {
			g.fillRect(WIDTH/6, HEIGHT/12, (int)((progress - obstacles.get(obstacles.size()-1).x + 5 * PLAYERWIDTH)/progress * 2*WIDTH/3), HEIGHT/36);
		}
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
	public void restart() {
		playerSpeed = defaultPlayerSpeed;
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.remove(i);
			if (i != 0) {
				i--;
			}
		}
		obstacles.remove(0);
		won = false;
		lost = false;
		player.x = ((int)WIDTH/4);
		player.y = groundHeight;
		
		spawn = true;
		jumping = false;
		System.out.println(obstacles.size());
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
			if (e.getKeyChar() == ' ') {
				spacePressed = true;
			}
			if (e.getKeyChar() == 'r') {
				restart();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyChar() == ' ') {
				spacePressed = false;
			}
		}
	});
	frame.add(canvas);
	frame.setVisible(true);
	while (spawn == true) {
		spawnObstacles();
	}
	while (!lost && !won) {
		if (!paused) {
			if (spacePressed) {
				jump();
			}
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
