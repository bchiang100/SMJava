package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoard {
	
	private int gridWidth = 800, gridHeight = 600, textHeight = 50;
	// my instance variables
	int firstDifference=-1;
	int secondDifference=-1;
	
	private final int NUMQUESTIONS = 5, NUMCATEGORIES = 6;
	
	private int score = 0;
	

	
	public void draw(Graphics g) {
		
		// how to draw your jeopardy board (categories going across, questions going down)
		// the first for loop is to print out the boxes in the x direction
		for (int i = 0; i < NUMCATEGORIES; i++) {
			// the second (nested) for loop is to print ou the boxes in the y direction
			for (int j = 0;j < NUMQUESTIONS; j++) {
				// colors the inside of the box green
				g.setColor(Color.green);
				g.fillRect(gridWidth/NUMCATEGORIES * j, gridHeight/NUMQUESTIONS * i, gridWidth/NUMCATEGORIES, gridHeight/NUMQUESTIONS);
				// colors the edges of the box black and creates numerical values that correspond to each category & question + sets the string's color to black
				g.setColor(Color.black);
				g.drawRect(gridWidth/NUMCATEGORIES * j, gridHeight/NUMQUESTIONS * i, gridWidth/NUMCATEGORIES, gridHeight/NUMQUESTIONS);
				Font f = new Font("Arial", Font.BOLD, 16);
				g.setFont(f);
				g.setColor(Color.black);
				g.drawString((i+1)*100 + "", gridWidth/NUMCATEGORIES * j + gridWidth/(NUMCATEGORIES*2), gridHeight/NUMQUESTIONS * i + gridHeight/(NUMQUESTIONS*2));
				if (i == firstDifference && j == secondDifference) {
					g.setColor(Color.red);
					g.drawString((i+1)*100+"", gridWidth/NUMCATEGORIES*j+gridWidth/(NUMCATEGORIES*2), gridHeight/NUMQUESTIONS*i+gridHeight/(NUMQUESTIONS*2));
				}
				}
		}
		}
	public void click(int mouseX, int mouseY) {
		
		// what you want to happen when the user clicks
		for (int i = 0; i < NUMCATEGORIES; i++) {
			for (int j = 0; j < NUMQUESTIONS; j++) {
				// aligning the boundaries of the box so that if the mouse is inside the boundary of a box the score will increase by the box's amount
				if ((mouseX >= gridWidth/NUMCATEGORIES * j && mouseX <= gridWidth/NUMCATEGORIES * (j+1) && (mouseY >= gridHeight/NUMQUESTIONS * i && mouseY <= gridHeight/NUMQUESTIONS * (i+1)))) {
					score = score + 100 * (i+1);
				}
			}
		}
	}
	
	
	// DO NOT TOUCH BELOW CODE //
	
	public JeopardyBoard() {
		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
				window.getContentPane().repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JeopardyBoard();
	}

}