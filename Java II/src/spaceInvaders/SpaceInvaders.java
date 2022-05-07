package spaceInvaders;

// Space Invaders Filler Code by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvaders {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 10, ALIENSPEED = 5, PLAYERLASERSPEED = 10, ALIENLASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35, LEVEL = 3, MAXLASERS = 4;
	
	// determines the difficulty. The closer to 1.0, the easier the game 
	private double DIFFICULTY = .99;
	// toggle between the different modes
	private boolean THEMATRIX = true;
	private boolean SHARPSHOOTER = false;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();
	
	// the player
	private SpaceThing player;
	
	// the current speed of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	
	private int levelCount = 1;
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		// looping aliens' movement
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).getX() < WIDTH) {
				aliens.get(i).moveX(ALIENSPEED);
			}
			else {
				aliens.get(i).moveX(-WIDTH);
				aliens.get(i).moveY(aliens.get(i).getImgHeight());
			}
			if (Math.random() > DIFFICULTY) {
				alienLasers.add(new Laser((int)aliens.get(i).getX()+ (int)aliens.get(i).getW()/2 - LASERWIDTH/2, (int)aliens.get(i).getY() + (int)aliens.get(i).getH(), LASERWIDTH, LASERHEIGHT, Color.red));
			}
		}
		// laser movement -- alien
		for (int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).moveY(ALIENLASERSPEED);
			if (alienLasers.get(i).getY() >= HEIGHT) {
				alienLasers.remove(i);
				i--;
			}
		}
		// laser movement -- player
		for (int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).moveY((int)(-PLAYERLASERSPEED));	
			if (playerLasers.get(i).getY() <= 0) {
				playerLasers.remove(i);
				i--;
			}
		}
		
		//  player's movement
		if (player.getX() + player.getW() < WIDTH && player.getX() > 0) {
			player.moveX(playerSpeed);
		} 
		if (player.getX()  + player.getW() >= WIDTH) {
			if (playerSpeed > 0) {
				playerSpeed = 0;
			}
			player.moveX(playerSpeed);
		}
		if (player.getX() <= 0) {
			if (playerSpeed < 0) {
				playerSpeed = 0;
			}
			player.moveX(playerSpeed);
		}	
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		// checks for collisions between alien lasers and the player
		for (int i = 0; i < alienLasers.size(); i++) {
			if (alienLasers.get(i).intersects(player)) {
				lives--;
				alienLasers.remove(i);
				if (i != 0) {
					i--;
				}
				if (lives == 0) {
					lost = true;
					return;
				}
			}
		}
		
		// checks for collisions between player lasers and an alien
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < playerLasers.size() && aliens.size() > 0; j++) {
				if (playerLasers.get(j).intersects(aliens.get(i))) {
					aliens.remove(i);
					playerLasers.remove(j);
					if (i != 0) {
						i--;
					}
					if (j != 0) {
						j--;
					}
				}
			}
		}
		
		// checks if all the aliens have been destroyed
		if (aliens.size() == 0 && levelCount == LEVEL) {
			won = true;
			return;
		}
		
		// checks if aliens have reached the ground
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).getY() + aliens.get(i).getH() >= HEIGHT) {
				lost = true;
				return;
			}
		}
		
		// (MINI EXTRA FEATURE #1) checks for collisions between player lasers and alien lasers
		for (int i = 0; i < alienLasers.size(); i++) {
			for (int j = 0; j < playerLasers.size(); j++) {
				if (alienLasers.get(i).intersects(playerLasers.get(j))) {
					alienLasers.remove(i);
					if (i!=0) {
						i--;
					}
					playerLasers.remove(j);
					if (j!=0) {
						j--;
					}
				}
			}
		}
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		int xChange = 0;
		int yChange = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < NUMALIENS/2; j++) {
				aliens.add(new SpaceThing(xChange, yChange, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
				xChange += PLAYERENEMYWIDTH;
			}
			if (NUMALIENS % 2 == 1 && i == 0) {
				aliens.add(new SpaceThing(xChange, yChange, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
			}
			xChange = 0;
			yChange += PLAYERENEMYHEIGHT;
		}
		player = new SpaceThing(WIDTH/2 - (PLAYERENEMYWIDTH/2), HEIGHT - 4 * PLAYERENEMYHEIGHT, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/playerCannon.jpg");
		
	}
	
	// (MINI EXTRA FEATURE #2) new mode! this game mode is created with inspiration to The Matrix. Have fun!
	public void thematrix() {
		if (THEMATRIX) {
			DIFFICULTY = 0.975;
			NUMALIENS = 20;
			ALIENLASERSPEED = 2;
			PLAYERLASERSPEED = 8;
			PLAYERSPEED = 7;
			MAXLASERS = 10;
			lives = 5;
			LEVEL = 5;
		}
	}
	// (MINI EXTRA FEATURE #3) new mode! this game mode requires you to be accurate with your shots, as every shot matters. the max amount of lasers you can fire at a time is 1 and the aliens are speedy!
	public void sharpshooter() {
		if (SHARPSHOOTER) {
			DIFFICULTY = 2;
			NUMALIENS = 8;
			ALIENSPEED = 20;
			PLAYERSPEED = 0;
			MAXLASERS = 1;
			LEVEL = 2;
		}
	}
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		if (playerLasers.size() >= MAXLASERS) {
			playerLasers.remove(0);
		}
		playerLasers.add(new Laser((int)player.getX() + (int)player.getW()/2 - LASERWIDTH/2, (int)player.getY(), LASERWIDTH, LASERHEIGHT, Color.green));
		
	}
	
	// (MAIN EXTRA FEATURE #4) enables the player to choose how many levels they want in the game (can be changed by changing the constant at the top of code)
	public void levels() {
		if (aliens.size() == 0 && levelCount < LEVEL) {
			DIFFICULTY *= 0.998;
			int times = 2;
			int xChange = 0;
			int yChange = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < NUMALIENS / (times / 2); j++) {
					aliens.add(new SpaceThing(xChange, yChange, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
					xChange += PLAYERENEMYWIDTH;
				}
				if (NUMALIENS % 2 == 1 && i == 0) {
					aliens.add(new SpaceThing(xChange, yChange, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
				}
				xChange = 0;
				yChange += PLAYERENEMYHEIGHT;
			}
			levelCount++;
		}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if (!lost && !won) {
			g.setColor(Color.red);
			g.drawString("Lives: "+lives, 15, 15);
			g.drawString("Level: " + levelCount + " out of " + LEVEL, 15, 30);
			for (SpaceThing alien : aliens) { 
				alien.draw(g);
			}
			for (Laser aLaser : alienLasers) {
				aLaser.draw(g);
			}
			player.draw(g);
			for (Laser pLaser : playerLasers) {
				pLaser.draw(g);
			}
		}
	
		// prints "you lost" if you lose
		if (lost) {
			g.setColor(Color.white);
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		}
		// prints "you win" if you win
		if (won) {
			g.setColor(Color.white);
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
		}
		if (lives == 1) {
			g.setColor(Color.red);
			g.drawString("ONE LIFE LEFT!!!", WIDTH/2, 30);
		}
		if (!THEMATRIX && !SHARPSHOOTER) {
			g.setColor(Color.white);
			g.drawString("Mode: Normal", 15, 45);
		}
		if (THEMATRIX) {
			g.setColor(Color.yellow);
			g.drawString("Mode: The Matrix", 15, 45);
			g.drawString("Make sure to dodge all the lasers by shooting them out!", 15, 60);
		}
		if (SHARPSHOOTER) {
			g.setColor(Color.yellow);
			g.drawString("Mode: Sharpshooter", 15, 45);
			g.drawString("Shoot them all before they reach the bottom! Remember, YOU CAN'T MOVE!!!", 15, 60);
		}
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvaders() {
		thematrix();
		sharpshooter();
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
				levels();
				frame.getContentPane().repaint();
			}
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}