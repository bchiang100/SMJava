package geometryDash;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

// to-do
// fix screen stretching (game has to work w/ different resolutions)
// make a non-repeater counter for spawning in presets so there is no constant repeats - done
// fix jumping issue (sometimes player won't jump) - need to figure out why

// ideas
// make a golden coin
public class GeometryDash {
	private int WIDTH = 1000, HEIGHT = 700, PLAYERWIDTH = 50, PLAYERHEIGHT = 50, GAMELENGTH = 5, DIFFICULTY = 7;
	// list of obstacles
	private ArrayList<GeometryObject> obstacles = new ArrayList<GeometryObject>();

	// map of locations
	private ArrayList<Integer> locations = new ArrayList<Integer>();
	
	//DONT CHANGE
	private double progress;
	private GeometryObject player;
	private GeometryObject backgroundImg;
	private double gravity = 1.5;
	private int totalBackgroundSpeed = 0, backgroundSpeed = -10, defaultPlayerSpeed = -19 , playerSpeed = defaultPlayerSpeed, boosterSpeed = defaultPlayerSpeed * 5 / 3, timerCount = -25 * GAMELENGTH, groundHeight = (int)(0.674 * HEIGHT), presetWidth = 0, obstacleHeight = 0, attempt = 1, drawTimer = 0, boosterHeight = (int)(0.25 * PLAYERHEIGHT), frequency = 0;;
	private boolean lost = false, won = false, paused = true, jumping = false, spacePressed = false;
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
				totalBackgroundSpeed += backgroundSpeed;
			}
		}
	}

	public void checkCollisions() {
		
		boolean hitSomething = false;
		for (int i = 0; i < obstacles.size(); i++) {
			if (player.x > obstacles.get(i).x + obstacles.get(i).width) {
				i++;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 1) {
				drawTimer = 0;
				totalBackgroundSpeed /= obstacles.size();
				for (int j = 0; j < obstacles.size(); j++) {
					obstacles.get(j).moveX(-totalBackgroundSpeed);
				}
				attempt++;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 0) {
				// I subtracted by playerSpeed since the player y value is not actually the obstacle's y value when it intersects, but rather a little below the obstacle
				if(player.y + player.height - playerSpeed <= obstacles.get(i).y) {
						obstacleHeight = groundHeight + player.height - obstacles.get(i).y;
						player.y = obstacles.get(i).y - player.height;
						jumping = false;
						hitSomething = true;
				} else {
					drawTimer = 0;
					totalBackgroundSpeed /= obstacles.size();
					for (int j = 0; j < obstacles.size(); j++) {
						obstacles.get(j).moveX(-totalBackgroundSpeed);
					}
					attempt++;
				}
			}
			if (player.y == groundHeight) {
				jumping = false;
			}
			if (obstacles.get(i).intersects(player) && obstacles.get(i).getType() == 2) {
				playerSpeed = boosterSpeed;
				jump();
			}
			if (obstacles.get(i).intersects(player) && spacePressed && obstacles.get(i).getType() == 3) {
			
				playerSpeed = (int)(0.5 * defaultPlayerSpeed);
				//System.out.println("SPEED IS " + playerSpeed);
				jump();
				
			}
			if (obstacles.get(i).intersects(player) && spacePressed && obstacles.get(i).getType() == 4) {
				playerSpeed = (int)(0.8 * defaultPlayerSpeed);
				//System.out.println("SPEED IS " + playerSpeed);
				jump();
			}
			if (obstacles.get(i).intersects(player) && spacePressed && obstacles.get(i).getType() == 5) {
				playerSpeed = (int)(1.2 * defaultPlayerSpeed);
				System.out.println("SPEED IS " + playerSpeed);
				System.out.println("TYPE IS " + obstacles.get(i).getType());
				jump();
			}
		
			// temporary win condition
			if (player.x > obstacles.get(obstacles.size() - 1).x) {
				won = true;
			}
		}
		if (!hitSomething) {
			if (player.y < groundHeight) {
				jumping = true;
			}
			obstacleHeight = 0;
		}
		
	}
	
	// creates a new obstacle and adds it to the obstacles list (makes creating obstacles easier for me)
	// x is the x location, y is the y location, and type is the type of GeometryObject
	public void create(double x, double y, int type) {
		// spawns square block
		if (type == 0) {
			obstacles.add(new GeometryObject((int)(WIDTH + x * PLAYERWIDTH + presetWidth), (int)(groundHeight - y * PLAYERHEIGHT), PLAYERWIDTH, PLAYERHEIGHT, "Images/SquareObstacle.png"));
		}
		// spawns triangle block
		if (type == 1) {
			obstacles.add(new TriangleObstacle((int)(WIDTH + x * PLAYERWIDTH + presetWidth), (int)(groundHeight - y * PLAYERHEIGHT), PLAYERWIDTH, PLAYERHEIGHT, "Images/TriangleObstacle.png"));
		}
		// spawns booster
		if (type == 2) {
			obstacles.add(new Booster((int)(WIDTH + x * PLAYERWIDTH + presetWidth), (int)(groundHeight - (y * PLAYERHEIGHT + boosterHeight - PLAYERHEIGHT)), PLAYERWIDTH, boosterHeight, "Images/OrangeRectangle.png"));
		}
		// spawns pink jump ring
		if (type == 3) {
			obstacles.add(new PinkRing((int)(WIDTH + x * PLAYERWIDTH + presetWidth), (int)(groundHeight - y * PLAYERHEIGHT), PLAYERWIDTH, PLAYERHEIGHT, "Images/PinkRing.png"));
		}
		// spawns yellow jump ring
		if (type == 4) {
			obstacles.add(new YellowRing((int)(WIDTH + x * PLAYERWIDTH + presetWidth), (int)(groundHeight - y * PLAYERHEIGHT), PLAYERWIDTH, PLAYERHEIGHT, "Images/YellowRing.png"));
		}
		// spawns red jump ring
		if (type == 5) {
			obstacles.add(new RedRing((int)(WIDTH + x * PLAYERWIDTH + presetWidth), (int)(groundHeight - y * PLAYERHEIGHT), PLAYERWIDTH, PLAYERHEIGHT, "Images/RedRing.png"));
		}
	}
	public void loadPreset1() {
		// loads obstacle preset 1
		create(0, 0, 1);
		create(1, 0, 1);
		create(2, 0, 0);
		create(6, 0, 0);
		create(6, 1, 0);
		create(10, 0, 0);
		create(10, 1, 0);
		create(10, 2, 0);
	}
	
	public void loadPreset2() {
		// loads preset 2
		create(0, 0, 0);
		create(4, 1, 0);
		create(8, 2, 0);
		create(11, 2, 0);
		create(12, 2, 0);
		create(13, 2, 0);
		create(14, 2, 0);
		create(14, 3, 1);
		create(14, 0, 1);
	}
	
	public void loadPreset3() {
		// loads preset 3
		create(0, 0, 2);
		create(1, 0, 1);
		create(2, 0, 1);
		create(3, 0, 1);
		create(4, 0, 1);
		create(8, 0, 1);
		create(9, 0, 1);
		create(13, 0, 1);
		create(14, 0, 1);
		create(15, 0, 0);
		create(18, 0, 0);
		create(18, 1, 0);
		create(22, 0, 2);
		create(23, 0, 1);
		create(24, 0, 1);
		create(25, 0, 1);
		create(26, 0, 1);
		create(27, 0, 1);
		create(27, 1, 0);
		create(28, 0, 1);
		create(29, 0, 1);
		create(30, 0, 1);
		
	}
	public void loadPreset4() {
		// loads preset 4
		create(0, 0, 1);
		create(1, 0, 1);
		create(1.5, 1, 3);
		create(2, 0, 1);
		create(3, 0, 1);
		create(4, 0, 1);
		create(5, 0, 0);
		create(9, 0, 0);
		create(9, 1, 0);
		create(13, 2, 4);
		create(17, 2, 0);
		create(18, 2, 0);
		create(18, 0, 1);
		create(19, 2, 0);
		create(20, 2, 0);
		create(25, 0, 0);
		create(26, 0, 1);
		create(27, 0, 1);
		create(35, 0, 1);
		create(35, 3, 0);
		create(36, 0, 1);
		create(36, 3, 0);
		create(39, 0, 1);
		create(39, 3, 0);
		create(40, 0, 1);
		create(40, 3, 0);
	}
	public void loadPreset5() {
		// loads preset 5
		create(0, 3.5, 0);
		create(1, 3.5, 0);
		create(2, 3.5, 0);
		create(3, 3.5, 0);
		create(4, 3.5, 0);
		create(5, 3.5, 0);
		create(6, 3.5, 0);
		create(1, 0, 2);
		create(5, 0, 2);
		create(11, 1, 3);
		create(9, 0, 1);
		create(10, 0, 1);
		create(11, 0, 1);
		create(12, 0, 1);
		create(13, 0, 1);
		
		create(17, 0, 1);
		create(20.5, 1, 0);
		create(20.5, 2, 0);
		create(20.5, 3, 1);
		
		create(24, 1.5, 5);
		create(27, 2, 0);
		create(28, 2, 0);
		create(29, 2, 0);
		create(31, 2.5, 0);
		create(31, 3.5, 1);
		create(33, 1.5, 0);
		create(35, 1, 0);
		create(37, 0, 0);
		create(41, 1, 0);
		create(41, 0, 0);
		create(42, 0, 1);
	}
	public void loadPreset6() {
		create(0, 0, 2);
		create(1, 0, 1);
		create(2, 0, 1);
		create(3, 0, 1);
		create(4, 0, 1);
		create(4, 1, 0);
		create(5, 0, 1);
		create(5, 1, 0);
		create(6, 0, 1);
		create(6, 1, 0);
		create(7, 2, 1);
		create(7, 0, 1);
		create(7, 1, 0);
		create(8, 0, 1);
		create(8, 1, 0);
		create(9, 0, 1);
		create(9, 1, 0);
		create(14, 0, 0);
		//
		create(18, 1, 0);
		create(18, 2, 1);
		create(21, 0, 2);
		create(22, 0, 1);
		create(23, 0, 0);
		create(23, 1, 0);
		create(24, 0, 1);
		create(25, 0, 1);
		create(26, 0, 1);
		create(27, 2, 5);
		create(27, 0, 1);
		create(28, 0, 1);
		create(29, 0, 1);
		create(30, 0, 1);
		create(31, 0, 0);
		create(31, 1, 0);
	}
	public void loadPreset7() {
		create(0, 0, 2);
		create(2, 0, 0);
		create(2, 1, 0);
		create(2, 2, 0);
		create(2, 3, 1);
		create(5, 3, 4);
		create(9, 4, 4);
		create(14, 3, 4);
		//
		create(18, 3, 0);
		create(19, 3, 0);
		create(20, 3, 0);
		//
		create(24, 3, 4);
		create(27, 3, 5);
		//
		create(29, 0, 0);
		create(29, 1, 0);
		create(29, 2, 0);
		create(30, 0, 0);
		create(30, 1, 0);
		create(30, 2, 0);
		create(30, 3, 2);
		//
		create(35, 5, 4);
		create(35, 0, 1);
		create(37, 6, 0);
		create(37, 7, 1);
;	}
	
	public void setup() {
		backgroundImg = new GeometryObject(0, 0, WIDTH, HEIGHT, "Images/GeometryDashBackground.jpeg");
		player = new GeometryObject(4 * -PLAYERWIDTH, groundHeight, PLAYERWIDTH, PLAYERHEIGHT, "Images/Cube.png");
	}
	public void spawnObstacles() {
		int temp = 0;
		while (temp < GAMELENGTH) {
			double random = (Math.random() * 100) + 1;
			presetWidth += 6;
			while (GAMELENGTH - 1 == temp) {
				if (DIFFICULTY == 1 && timerCount > 0) {
					loadPreset1();
					temp++;
				}
				if (DIFFICULTY == 2 && timerCount > 0) {
					loadPreset2();
					temp++;
				}
				if (DIFFICULTY == 3 && timerCount > 0) {
					loadPreset3();
					temp++;
				}
				if (DIFFICULTY == 4 && timerCount > 0) {
					loadPreset4();
					temp++;
				}
				if (DIFFICULTY == 5 && timerCount > 0) {
					loadPreset5();
					temp++;
				}
				if (DIFFICULTY == 6 && timerCount > 0) {
					loadPreset6();
					temp++;
				}
				if (DIFFICULTY == 7 && timerCount > 0) {
					loadPreset7();
					temp++;
				}
				break;
			}
			if (random > 1 && random < 1.5 && timerCount > 0 && frequency != 1 && DIFFICULTY >= 1) {
				frequency = 1;
				loadPreset1();
				timerCount = -200;
				temp++;
			}
			if (random > 1.5 && random < 2 && timerCount > 0 && frequency != 2 && DIFFICULTY >= 2) {
				frequency = 2;
				loadPreset2();
				timerCount = -200;
				temp++;
			}
			if (random > 2 && random < 2.8 && timerCount > 0 && frequency != 3 && DIFFICULTY >= 3) {
				frequency = 3;
				loadPreset3();
				timerCount = -400;
				temp++;
			}
			if (random > 2.8 && random < 3.6 && timerCount > 0 && frequency != 4 && DIFFICULTY >= 4) {
				frequency = 4;
				loadPreset4();
				timerCount = -400;
				temp++;
			}
			if (random > 3.6 && random < 4.5 && timerCount > 0 && frequency != 5 && DIFFICULTY >= 5) {
				frequency = 5;
				loadPreset5();
				timerCount = -400;
				temp++;
			}
			if (random > 4.5 && random < 5.5 && timerCount > 0 && frequency != 6 && DIFFICULTY >= 6) {
				frequency = 6;
				loadPreset6();
				timerCount = -500;
				temp++;
			}
			if (random > 5.5 && random < 6.7 && timerCount > 0 && frequency != 7 && DIFFICULTY >= 7) {
				frequency = 7;
				loadPreset7();
				timerCount = -500;
				temp++;
			}
			timerCount++;

		}
		
			progress = obstacles.get(obstacles.size()-1).x;
			//maybe add a wall in the ending
			//obstacles.add(new Rectangle(obstacles.get(obstacles.size()-1).x + 200), 0, 20, HEIGHT)));
			for (int i = 0; i < obstacles.size(); i++) {
				locations.add(obstacles.get(i).x);
				//System.out.println(locations.get(obstacles.get(i)));
			}
			paused = !paused;
		
	} 
	
	public void jump() {
		if (jumping == false) {
			
			if (playerSpeed != boosterSpeed) {
				
				playerSpeed = defaultPlayerSpeed;
			}
			jumping = true;
			player.moveY(playerSpeed);
			playerSpeed += gravity;
		}
	}
	public void draw(Graphics g) {
		backgroundImg.draw(g);
		if (won == false) {
			player.draw(g);
			for (int i = 0; i < obstacles.size(); i++) {
				obstacles.get(i).draw(g);
			}
		}
		
		//System.out.println((progress - obstacles.get(obstacles.size()-1).x + 5 * PLAYERWIDTH));
		g.drawRect(WIDTH/6, HEIGHT/12, 2*WIDTH/3, HEIGHT/36);
		if (drawTimer < 100) {
			Font f = new Font("Arial", Font.BOLD, 26);
			g.setFont(f);
			g.drawString("Attempt " + attempt, WIDTH/2-25, HEIGHT/3);
			drawTimer++;
		}
		//make sure its not empty
		if ((progress - obstacles.get(obstacles.size()-1).x)/progress <= 2*WIDTH/3) {
			g.fillRect(WIDTH/6, HEIGHT/12, (int)((progress - obstacles.get(obstacles.size()-1).x + 5 * PLAYERWIDTH)/progress * 2*WIDTH/3), HEIGHT/36);
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
	public void restart() {
		drawTimer = 0;
		playerSpeed = defaultPlayerSpeed;
		totalBackgroundSpeed /= obstacles.size();
		for (int j = 0; j < obstacles.size(); j++) {
			obstacles.get(j).moveX(-totalBackgroundSpeed);
		}
		won = false;
		player.x = 2 * -PLAYERWIDTH;
		if (player.x < (int)(WIDTH/4)) {
			player.moveX(7);
		}
		player.y = groundHeight;
		attempt = 1;
		jumping = false;
		
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
		spawnObstacles();
	
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
