package homework;

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
	public class GraphicalLoops extends JPanel {
		int circle_x=50;
		int circle_y=50;
		int circle_width=50;
		int circle_height=50;
		//constant runtine
		public void circle(Graphics g, int n) {
			for (int i=0;i<n;i++) {
				g.fillOval(circle_x, circle_y, circle_width, circle_height);
				circle_x=circle_x+100;
				circle_y=circle_y+100;
			}
			
		}
		//linear runtime
		public void differentSizes(Graphics g, int n) {
			int count=n-1;
			for (int i=0;i<n;i++) {
				for (int j=0;j<count;j++) {
					g.fillOval(circle_x, circle_y, circle_width, circle_height);
					circle_x=circle_x+100;
					circle_y=circle_y+100;
					circle_width-=5;
					circle_height-=5;
					count--;
				}
			}
		count = 0;
		for (int i=n;i>0;i--) {
			for (int j=0;j<count;j++) {
				g.fillOval(circle_x, circle_y, circle_width, circle_height);
				circle_x=circle_x+100;
				circle_y=circle_y+100;
				circle_width+=5;
				circle_height+=5;
				count++;
			}
		}
		}
		//quadratic runtime
		public void tenRows(Graphics g) {
			for (int i=0;i<10;i++) {
				for (int j=0;j<10;j++) {
					g.fillOval(circle_x, circle_y, circle_width, circle_height);
					circle_x=circle_x+100;
				}
				circle_y=circle_y+100;
			}
		}
		//This method below is a self-made one. I tried to make a triangle of circles using nested loops. (linear runtime)
		public void triangleCircle(Graphics g, int n) {
			for (int i=0; i<n;i++) {
				for (int j=0;j<i;j++) {
					g.fillOval(circle_x, circle_y, circle_width, circle_height);
					circle_x=circle_x+100;
				}
				circle_y+=100;
			}
		}
		//linear runtime
		public void rectangles(Graphics g) {
			for (int i=0;i<5;i++) {
				for (int j=0;j<i;j++) {
					g.fillRect(circle_x, circle_y, 100, 50);
				}
				g.setColor(Color.blue);
				g.setColor(Color.green);
				g.setColor(Color.red);
				g.setColor(Color.yellow);
				g.setColor(Color.orange);
			}
		}
		// constants that are predefined and won't change as the program runs
		private final int WIDTH = 1000, HEIGHT = 590;
		// defines what we want to happen anytime we draw the graphics
		public void paint(Graphics g) {
			// background color is gray
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			// call your methods here
			}
		//////////////////////////////////////
		//////////////////////////////////////
		// DON'T TOUCH THE BELOW CODE
		// this method runs the actual program.
		public void run() {
		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
			while (true) {
				// draws
				//repaint();
				//rests for a hundredth of a second
				try {
					Thread.sleep(10);
				} catch (Exception ex) {}
			}
			}
			// very simple main method to get the game going
		public static void main(String[] args) {
		GraphicalLoops runner = new GraphicalLoops();
		//I didnt know if i should have included Graphics g into the parameter, null, or nothing. It gave me null as a default so I used that. However, none of the graphics would load.
		runner.circle(null, 5);
		runner.differentSizes(null, UNDEFINED_CONDITION);
		runner.tenRows(null);
		runner.triangleCircle(null, 5);
		runner.rectangles(null);
		new GraphicalLoops();
		}
		 
		// does complicated stuff to initialize the graphics and key listeners
		// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
		// GRAPHICS!
		public GraphicalLoops() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		run();
		}
		}

