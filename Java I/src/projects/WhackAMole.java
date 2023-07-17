package projects;

import java.awt.Color;

// Filler code for Whack a Mole by Mr. Friedman

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class WhackAMole {

	// size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35; 
    
    private Image moleImg, bgImg, dirtImg;

    // constants for the number of moles, number of moles appearing at a time, and the 
    // time gap between new moles popping up (in milliseconds)
    private final int NUMMOLES = 10, TIMESTEP = 2000;
    int NUMAPPEARING = 2;
    
    private int[] x, y;			// locations of the moles
    private boolean[] showing = new boolean[NUMMOLES];	// keeps track of which moles are popped up
    
    private int score;
    int boundaryLow = windowWidth / 9;
    int boundaryHigh = windowWidth * 3 / 5;
    double target_x_coordinate = Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow) + boundaryLow);
    double target_y_coordinate = Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow)) + boundaryLow;
    double estimate = Math.random();
    int[] moles_x = new int[NUMMOLES];
    int[] moles_y = new int[NUMMOLES];
    boolean[] powerupChance = new boolean[NUMMOLES];
    int dirtWidth = 100;
    int dirtLength = 100;
    int spacingCount_x;
    int spacingCount_y;
    boolean check = true;
    int showingRand;
    int moleWidth = 100;
    int moleHeight = 150;
    int powerUpRadius = 50;
    int powerUpX = (int)Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow)) + boundaryLow;
    int powerUpY = (int)Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow)) + boundaryLow;
    int moleCheck;
    //int showingTrue;
    // more instance variables...?
    
   
    public void setup() {
    	
    	// loads your 3 images - all you need to do is match file names.
		moleImg = Toolkit.getDefaultToolkit().getImage("CartoonMole.png");
		bgImg = Toolkit.getDefaultToolkit().getImage("GrassCartoonBackground.jpeg");
		dirtImg = Toolkit.getDefaultToolkit().getImage("DirtMound.png");
		
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// I tried to load the dirt in as ordered rows and column that move in respect to the window size so that the spawned dirt mounds look more orderly and clean but was unsuccessful
		
//		for (int i = 0; i < moles_y.length; i++) {
//				for (int j = 0; j < moles_x.length; j++) {
//					if (spacingCount_x + dirtWidth< windowWidth) {
//						System.out.println("wassup");
//						spacingCount_x = (windowWidth/NUMMOLES) * j;
//						moles_x[j] = spacingCount_x;
//						spacingCount_x = spacingCount_x + dirtWidth * 2;
//						moles_y[i] = spacingCount_y;
//					}
//					spacingCount_x = 0;
//				}
//				spacingCount_y = (windowHeight/NUMMOLES) * i;
//		
//				break;
//		}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		for (int i = 0; i < moles_y.length; i++) {
			spacingCount_y = (windowHeight/NUMMOLES) * i;
			moles_y[i] = spacingCount_y;
		}
		
	    
		// your code here
		for (int i = 0; i < moles_x.length; i++) {
			moles_x[i] = (int)Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow)) + boundaryLow;
			
		}
		for (int i = 0; i< moles_y.length; i++) {
			moles_y[i] = (int)Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow) + boundaryLow);
			
		}
		for (int i = 0; i < moles_x.length; i++) {
        	for (int j = 0; j < moles_x.length; j++) {
        		if (i == j) {
        			continue;
        		}
        		if (moles_x[i] + dirtWidth > moles_x[j]) {
        			moles_x[i] = (int)Math.floor(Math.random() * (1 + boundaryHigh - boundaryLow)) + boundaryLow;
        		}
        	}
        }
    }
   

    public void draw(Graphics g) {
    	
    	// draws the background image at 0,0 with a size that will cover 
    	// the entire display window
   
    	//draws the background grass image
        g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
        
        //sets a random number from 0 to NUMMOLES-1 (because it is an integer so it will round down)
        showingRand = (int)(Math.random() * NUMMOLES);
        
        //the powerupChance array is essentially a probability, or chance, that the powerup will show up. If there are 10 moles then the chance is 1/10
        powerupChance[showingRand] = true;
        if (powerupChance[0] == true) {
        	g.setColor(Color.red);
        	g.fillOval(powerUpX, powerUpY, powerUpRadius, powerUpRadius);
        	powerupChance[0] = false;
        }
        for (int i = 0; i < NUMAPPEARING; i++) {
        	showingRand = (int)(Math.random() * NUMMOLES);
        	if (showing[showingRand] != true) {
        	showing[(int)(Math.random() * NUMMOLES)] = true;
        	}
        }
        //the check variable here essentially acts as a radio signal. if check is set to false then it will relay down to the below class and will start the loop which ensures that the methods will go in order
        //however, I am not too sure if this is necessary
        check = false;
        
        for (int i = 0; i < NUMMOLES; i++) {
        	if (showing[i] == true) {
        		g.drawImage(moleImg, moles_x[i], moles_y[i]-dirtLength, moleWidth, moleHeight, null);
        	}
        }
        
        //draws the dirt mounds
        for (int i = 0; i < moles_x.length; i++) {
        	g.drawImage(dirtImg, moles_x[i], moles_y[i], dirtWidth, dirtLength, null);
        }
        check = false;
    }

    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	//if the mouse is hovering over the mole when the mouse is clicked, the score will increase by 100
    	for (int i = 0; i < NUMMOLES; i++) {
    		if (mouseX > moles_x[i] && mouseX < moles_x[i] + dirtWidth && mouseY < moles_y[i] && mouseY > moles_y[i] - moleHeight) {
    			//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    			// MESSAGE: When I ran the program the i was always printed out as either a 6 or 8 which I didn't understand why. This probably led to the showing[i] not being true in most cases and not adding up the score. I have tried many methods to fix this but none of them worked.
        		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    			if (showing[i] == true) {
        			score+=100;
        			showing[i] = false;
        		}
    		}
    		//checks to see if the above class has been run. if it has then check will be false which will initiate this loop
    		if (check == false) {
    			for (int j = 0; j < showing.length; j++) {
        			showing[j] = false;
    			}
    			check = true;
    		}
    	}
    	//if the powerup (red circle) is pressed then the number of moles appearing on the screen will increase by 1 therefore making it easier to score points
    	if (mouseX > powerUpX && mouseX < powerUpX + powerUpRadius && mouseY > powerUpY && mouseY < powerUpY + powerUpRadius) {
    		NUMAPPEARING+=1;
    	}
    }
    
    // what you want to happen when the time for the current round ends
    public void timeAdvance() {
    	//after each round the array of moles showing up will be false so that the round can restart
    	for (int i = 0; i < showing.length; i++) {
    		showing[i] = false;
    	}
    }
    
    // reset the game
    public void reset() {
    	//if the reset button is pressed the showing[] array will be set to all false to reset the moles popping up
    	new WhackAMole();
    	score = 0;
    	for (int i = 0; i < showing.length; i++) {
    		showing[i] = false;
    	}
    }


    // DO NOT TOUCH BELOW CODE //

    public WhackAMole() {
    	
    	setup();

        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
                scoreDisplay.setText("\t\tScore: " + score);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                
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
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        
        new Timer(TIMESTEP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	timeAdvance();
            	window.getContentPane().repaint();
            }
        }).start();
    }
    

    public static void main(String[] args) {
        new WhackAMole();
    }

}