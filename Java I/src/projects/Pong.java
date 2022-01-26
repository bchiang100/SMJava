package projects;
// filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 8, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 4;

	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false;
	boolean score1=false;
	boolean score2=false;
	int ball_x_coordinate = 300;
	int ball_y_coordinate = 300;
	int ball_x_addNum=2;
	int ball_y_addNum=3;
	int ball_diameter = 15;
	int paddle_x_coordinate1 = 50;
	int paddle_y_coordinate1 = 300;
	int paddle_x_coordinate2 = 550;
	int paddle_y_coordinate2 = 300;
	int paddle_y_addNum=PADDLE_SPEED;
	int powerupLow=100;
	int powerupHigh=500;
	double powerup_x_coordinate=Math.floor(Math.random() * (1 + powerupHigh - powerupLow)) + powerupLow;
	double powerup_y_coordinate=Math.floor(Math.random() * (1 + powerupHigh - powerupLow)) + powerupLow;
	int powerup_diameter=30;
	int powerup_increase_speed=0;
	int player_one_scoreboard=0;
	int player_two_scoreboard=0;
	boolean powerupBool=false;
	boolean wallCheck1=false;
	boolean wallCheck2=false;
	// this method moves the ball at each timestep
	public void move_ball() {
		
		// your code here //
		ball_x_coordinate = ball_x_coordinate + ball_x_addNum;
		ball_y_coordinate = ball_y_coordinate + ball_y_addNum;
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (down1) {
		paddle_y_addNum=paddle_y_addNum*-1;
		paddle_y_coordinate1 = paddle_y_coordinate1 + paddle_y_addNum;
		paddle_y_addNum=paddle_y_addNum*-1;
		}
		if (up1) {
		paddle_y_coordinate1 = paddle_y_coordinate1 + paddle_y_addNum;
		}
		if (down2) {
		paddle_y_addNum=paddle_y_addNum*-1;
		paddle_y_coordinate2 = paddle_y_coordinate2 + paddle_y_addNum;
		paddle_y_addNum=paddle_y_addNum*-1;
		}
		if (up2) {
		paddle_y_coordinate2 = paddle_y_coordinate2 + paddle_y_addNum;
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		// your code here
		if (ball_x_coordinate>=600) {
			score1=true;
		}
		if (ball_y_coordinate>=600) {
			ball_y_addNum=-ball_y_addNum;
		}
		if (ball_x_coordinate<=0) {
			score2=true;
		}
		if (ball_y_coordinate<=0) {
			ball_y_addNum=-ball_y_addNum;
		}
		if (ball_x_coordinate == paddle_x_coordinate1 && ball_y_coordinate <=paddle_y_coordinate1 + PADDLE_HEIGHT && ball_y_coordinate>=paddle_y_coordinate1) {
			ball_x_addNum= -ball_x_addNum;
			//ball_y_addNum= -ball_y_addNum;
		}
		if (ball_x_coordinate == paddle_x_coordinate2 && ball_y_coordinate <= paddle_y_coordinate2 + PADDLE_HEIGHT && ball_y_coordinate>=paddle_y_coordinate2) {
			ball_x_addNum= -ball_x_addNum;
//			ball_y_addNum= -ball_y_addNum;
		}
		if (ball_x_coordinate<powerup_x_coordinate+powerup_diameter && ball_x_coordinate>powerup_x_coordinate-powerup_diameter && ball_y_coordinate<powerup_y_coordinate+powerup_diameter && ball_y_coordinate>powerup_y_coordinate-powerup_diameter) {
			if (ball_x_addNum>0) {
				ball_x_addNum=ball_x_addNum+powerup_increase_speed;
				wallCheck1=true;
			}
			if (ball_x_addNum<0) {
				ball_x_addNum=ball_x_addNum-powerup_increase_speed;
				wallCheck2=true;
			}
			if (ball_y_addNum>0) {
				ball_y_addNum=ball_y_addNum+powerup_increase_speed;
			}
			if (ball_y_addNum<0) {
				ball_y_addNum=ball_y_addNum-powerup_increase_speed;
			}
			powerupBool=true;
//			
		}
	}
	public void score() {
		if (score1==true) {
			player_one_scoreboard++;
			System.out.println("Player 1 scored! Player 1 now has " + player_one_scoreboard + " points!");
			ball_x_coordinate=300;
			ball_y_coordinate=300;
			ball_x_addNum=1;
			ball_y_addNum=3;
			score1=false;
		}
		if (score2==true) {
			player_two_scoreboard++;
			System.out.println("Player 2 scored! Player 2 now has " + player_two_scoreboard + " points!");
			ball_x_coordinate=300;
			ball_y_coordinate=300;
			ball_x_addNum=1;
			ball_y_addNum=3;
			score2=false;
		}
	}
	public void AI() {
		if (solo==true) {
			paddle_y_coordinate2=ball_y_coordinate-PADDLE_WIDTH/2;
		}
	}

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		// .......
		g.setColor(Color.blue);
		g.fillRect(paddle_x_coordinate1, paddle_y_coordinate1, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(paddle_x_coordinate2, paddle_y_coordinate2, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.setColor(Color.red);
		g.fillOval(ball_x_coordinate, ball_y_coordinate, ball_diameter, ball_diameter);
		if (powerupBool==false) {
			g.fillOval((int)powerup_x_coordinate, (int)powerup_y_coordinate, powerup_diameter, powerup_diameter);
		}
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("P1 Score: " + player_one_scoreboard, WIDTH/5, 20);
		g.drawString("P2 Score: " + player_two_scoreboard, WIDTH*3/5, 20);
		if (wallCheck1) {
			g.fillRect(500, 0, 20, 600);
			g.drawString("Player 2 activated a free shield!", 250, 300);
			if (ball_x_coordinate==500) {
				ball_x_addNum=-ball_x_addNum;
				wallCheck1=false;
			}
		}
		if (wallCheck2) {
			g.fillRect(100, 0, 20, 600);
			g.drawString("Player 1 activated a free shield!", 250, 300);
			if (ball_x_coordinate==100) {
				ball_x_addNum=-ball_x_addNum;
				wallCheck2=false;
			}
		}
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) {
			up2=true;
		}
			
		if (keyCode == KeyEvent.VK_UP) {
			down2=true;
		}
		

		if (e.getKeyChar() == 's') {
			up1=true;
			
		}
		if (e.getKeyChar() =='w') {
			down1=true;
			
		}
		// turn 1-player mode on
		if (e.getKeyChar() == '1') {
			solo=true;
		}
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2') {
			solo=false;
		}
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) {
			down2=false;
		}
			// fill this in

		if (keyCode == KeyEvent.VK_DOWN) {
			up2=false;
		}
			// fill this in
		
		if(e.getKeyChar() == 'w') {
			down1 = false;
		}
			// fill this in
		
		if (e.getKeyChar() == 's') {
			up1 = false;
		}
			// fill this in
	}
	
	// restarts the game, including scores
	public void restart() {

		run();
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			score();
			AI();
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}