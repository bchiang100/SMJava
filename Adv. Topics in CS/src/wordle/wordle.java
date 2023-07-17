package wordle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;

import java.io.BufferedReader;
import java.io.FileReader;
//import classwork.Block;
import java.io.IOException;
import java.awt.Font;
public class wordle{
	
	private final int WIDTH = 700, HEIGHT = 600;
	private int xTemp = 100, yTemp = 50, county = 0, countx = 0, random;
	private char inputLetter;
	private boolean pressed = false, entered = false, go = true, won = false, lost = false, delete = false;
	// checks if the binary search function should be called
	private static boolean doBinarySearch = false;
	// turns the secret answer into an array
	private static Character[] secretAnswer = new Character[5];
	// stores the location of the blocks
	private grid[][] blocks = new grid[6][5];
	// array of your character inputs
	private Character[][] characters = new Character[6][5];
	// stores the submitted word
	private static String submittedWord = "";
	// turns the current submitted word into an array of characters
	private static Character[] submittedWordArray = new Character[5];
	// stores information for each grid color
	private static Color[] gridColors = new Color[5];
	
	// letters a through z
	private static Character[] letterBank = new Character[26];
	// array of the character colors (gray, yellow, green)
	private static String[] charColor = new String[5];
	private static String checkValidity = "";
	// list of the possible wordle answers
	List<String> wordleValidAnswers = new ArrayList<String>();
	// list of all dictionary words which naturally include all the possible wordle answers and more
	List<String> dictionary = new ArrayList<String>();

	public void setup() {
		// sets up the character colors, block placements, and the letter bank
		for (int i = 0; i < charColor.length; i++) {
			charColor[i] = "";
		}
		Arrays.fill(gridColors, Color.white);
		for (int i = 0; i < 26; i++) {
			letterBank[i] = (char) (i + 65);
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				blocks[i][j] = new grid(xTemp, yTemp);
				xTemp += 60;
			}
			xTemp = 100;
			yTemp += 60;
		}
		for (int i = 0; i < characters.length; i++) {
			for (int j = 0; j < characters[i].length; j++) {
				characters[i][j] = ' ';
			}
		}
	}
	
	public void draw(Graphics g) {
		int move = 5;
		// draws a white background
		g.setColor(Color.WHITE);
		g.fillRect(0,0, WIDTH, HEIGHT);
		// sets (and updates) the color of the grids
		for (int i = 0; i < blocks[0].length; i++) {
			if (countx != 0) {
			blocks[countx-1][i].setColor(gridColors[i]);
			}
		}
		// draws the letter bank
		for (int i = 0; i < 26; i++) {
			g.setColor(Color.black);
			g.drawString(String.valueOf(letterBank[i]), 100 + move, 550);
			move+=20;
		}
		// prints instructions
		g.drawString("Instructions", 500, 50);
		g.drawString("Your goal is to guess the secret word", 420, 90);
		g.drawString("in 6 moves. The game ends when you either", 410, 110);
		g.drawString("find the secret word or run out of attempts.", 410, 130);
		g.drawString("Your guesses must be valid words", 430, 150);
		
		g.drawString("Legend", 520, 200);
		g.drawString("Green = corect letter, correct position", 420, 230);
		g.drawString("Yellow = correct letter, wrong position", 420, 250);
		g.drawString("Gray = the letter isn't in the word", 420, 270);
			
		g.drawString("Letter Bank", 340, 510);
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				g.setColor(Color.blue);
				blocks[i][j].draw(g);
			}
		}
		
		if (county == 5) {
			for (int i = 0; i < secretAnswer.length && checkValidity.length() < 5; i++) {
				checkValidity += characters[countx][i];
			}
		}
			if (!go) {
			
				g.setColor(Color.black);
				if (binSearch(checkValidity, dictionary, 0, dictionary.size()-1) == 1) {
					g.setColor(Color.blue);
					g.drawString("Press Enter to Confirm", 300, 450);
					if (entered) {
						//checks to see if the answer is correct or not and checks each individual character
						checkAnswer();
						entered = false;
						go = true;
						countx++;
						county=0;
					}
				} else {
					g.drawString("You guess is not a word", 300, 450);
				}
			}
		for (int i = 0; i < secretAnswer.length; i++) {
			// updates the letter bank (# means not present, @ means present but not correct place, $ means correct)
			if (charColor[i] == "Gray") {
				letterBank[submittedWordArray[i] - 97] = '#';
			}
			if (charColor[i] == "Yellow") {
				letterBank[submittedWordArray[i] - 97] = '@';
			}
			if (charColor[i] == "Green") {
				letterBank[submittedWordArray[i] - 97] = '$';
			}
		}
		
		if (pressed && go) {
			characters[countx][county] = inputLetter;
			county++;
			if (county >= blocks[0].length) {
				go = false;
			}
			pressed = false;
		}
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
			g.setColor(Color.black);
			g.drawString(String.valueOf(characters[i][j].toUpperCase(characters[i][j])), blocks[i][j].getX() + 20, blocks[i][j].getY() + 30);
			}
		}
	}
	
	//searches the word in the dictionary a lot faster, since the dictionary contains a lot of words
	public static int binSearch(String s, List<String> words, int start, int end) {
		int left = start;
		int right = end;
		while (left <= right) {
			int mid = (left + right)/2;
			if (s.equals(words.get(mid))) {
				return 1;
			}
			else if (s.compareTo(words.get(mid)) < 0) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return -1;
	}
	
	
	public String checkAnswer() {
		
		for (int i = 0; i < charColor.length; i++) {
			charColor[i] = "Gray";
		}
		submittedWord = "";
		for (int i = 0; i < characters[0].length; i++) {
			submittedWordArray[i] = characters[countx][i];
			
			submittedWord += characters[countx][i];
		}
		if (Arrays.equals(submittedWordArray, secretAnswer)) {
			won = true;
		}
		for (int i = 0; i < secretAnswer.length; i++) {
			for (int j = 0; j < secretAnswer.length; j++) {
				gridColors[i] = Color.gray;
				
				if (submittedWordArray[i] == secretAnswer[j] && i != j) {
					
					gridColors[i] = Color.yellow;
					charColor[i] = "Yellow";
					if (submittedWordArray[i] == secretAnswer[i]) {
						gridColors[i] = Color.green;
					}
					break;
				} 
				if (submittedWordArray[i] == secretAnswer[j] && i == j) {
					gridColors[i] = Color.green;
					charColor[i] = "Green";
					break;
				}		
			}
		}
		return submittedWord;
	}
	
	
	
	public wordle() throws IOException {
		// generates the word list from the valid wordle words file
		BufferedReader in = new BufferedReader(new FileReader("Images/valid-wordle-words.txt"));
		
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			dictionary.add(line.trim());
		}
		in.close();
		// generates a word list from the wordle solutions file
		BufferedReader in2 = new BufferedReader(new FileReader("Images/wordle-solutionsNYT.txt"));
		for (String line = in2.readLine(); line != null; line = in2.readLine()) {
			wordleValidAnswers.add(line.trim());
		}
		in2.close();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
			random = (int)(Math.random() * 2283);
		for (int i = 0; i < 5; i++) {
			secretAnswer[i] = wordleValidAnswers.get(random).charAt(i);
		}
		setup();
		JPanel c = new JPanel() {
			public void paintComponent(Graphics g) {
				//draws everything and updates every frame
				draw(g);
				if (countx == 6 && !won) {
					lost = true;
				}
				if (won) {
					g.setColor(Color.black);
					g.drawString("You got it! Nice job", 300, 430);
					go = false;
					entered = false;
				}
				if (lost) {
					g.setColor(Color.black);
					g.drawString("Good try... The correct answer was " + wordleValidAnswers.get(random), 300, 430);
					go = false;
					entered = false;
				}

			}
		};
		frame.add(c);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {		
				char keyCode = e.getKeyChar();
				// accounts for capitalization inputs
				if (go && keyCode >= 65 && keyCode <= 90) {
					keyCode += 32;
				}
				if (go && keyCode >= 97 && keyCode <= 122) {
					pressed=true;
					inputLetter = keyCode;
				}
			}
	

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode = e.getKeyCode();
				// if the enter key is pressed
				if (keyCode == KeyEvent.VK_ENTER && county == secretAnswer.length) {
					entered = true;
				}
				//if the delete key is pressed
				if (keyCode == KeyEvent.VK_BACK_SPACE) {
					delete = true;
					if (delete) {
						checkValidity = "";
						go = true;
						entered = false;
						if (county != 0) {
							characters[countx][county-1] = ' ';
							county--;
						}
						delete = false;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		
		
		JLabel l = new JLabel();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			frame.repaint();
			try {
				Thread.sleep(60);
			}
			catch(InterruptedException e) {}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// runs the program
		new wordle();
	}
}