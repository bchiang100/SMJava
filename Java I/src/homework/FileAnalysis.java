package homework;
// Program to provide simple text analysis on a chosen file
// Filler code by Mr. David

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileAnalysis {
	private final int WIDTH = 600, HEIGHT = 600;
	private String content = "Faded Lyrics.txt";
	private String[] contentArray = content.split(" ");
 	
	// return an array of size 26, where each entry in the array is the 
	// frequency of the corresponding letter (the first value represents 
	// the frequency of 'a', the second 'b', and so on
	private int[] calcFrequencies() {
		int[] freqs = new int[26];
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) <= 'z' && content.charAt(i) >= 'a') {
				freqs[content.charAt(i)-97]++;
			}
			else if (content.charAt(i) <= 'Z' && content.charAt(i) >= 'A') {
				freqs[content.charAt(i)-65]++;
			}
		}
		return freqs;
	}
	
	// returns the number of words in the file
	private int numWords() {
		return content.split(" ").length;		
	}
	
	// returns the number of lines in the file
//	private int numLines() {
//		for (int i = 0; i < contentArray.length; i++) {
//			
//		}
//	}
	
	// returns the longest word in the file
	private String longestWord() {
		String longestWord = "";
		for (int i = 0; i < contentArray.length; i++) {
			if (contentArray[i].length() > longestWord.length()) {
				longestWord = contentArray[i];
			}
		}
		return longestWord;
	}
	
	// returns the most common letter in the file
	private char mostCommonLetter() {
		int[] freqs = calcFrequencies();
		int mostCommonLetter = 0;
		for (int i = 0; i < freqs.length; i++) {
			if (freqs[i] > mostCommonLetter) {
				mostCommonLetter = freqs[i];
			}
		}
		return (char)(mostCommonLetter + 26);
	}
	
	// returns the most common word in the file
	private String mostCommonWord() {
		String CommonWord;
		int mostCommonOccurrence = 0;
		int mostCommonOccurrence2 = 0;
		String mostCommonWord = "";
		for (int i = 0; i < contentArray.length; i++) {
			CommonWord = contentArray[i];
			for (int j = 0; j < contentArray.length; j++) {
				if (CommonWord == contentArray[i]) {
					mostCommonOccurrence++;
				}
			}
			if (mostCommonOccurrence > mostCommonOccurrence2) {
				mostCommonOccurrence2 = mostCommonOccurrence;
				mostCommonWord = CommonWord;
			}
		}
		return mostCommonWord;
	}
	
	// returns the ten most common words (of length > 5) in 
	// the file, in order from most common to least common
//	private String[] tenMostCommonWords() {
//		
//		// your code here
//	}
	
	// returns the longest sentence in the file
//	private String longestSentence() {
//		
//		// your code here
//	}
	
	// returns the percent of characters in the file that are vowels.
	// cast the decimal to a string, shorten it to a few decimal 
	// points, then add a % sign to the end
	private String percentVowels() {
		int[] freqs = calcFrequencies();
		int vowels = freqs[0] + freqs[5] + freqs[9] + freqs[15] + freqs[21];
		int totalChar = 0;
		double percentage;
		int temp;
		for (int i = 0; i < freqs.length; i++) {
			totalChar+=freqs[i];
		}
		percentage = vowels / totalChar;
		temp = (int)(percentage * 100);
		percentage = (double)temp;
		percentage/=100;
		return ""+percentage + "%";
	}
	
	
	// ***** STOP HERE ***** //

	
	public FileAnalysis() {
		
		JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir"));
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		if (f == null)
			System.exit(-1);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));

			for (int letter = in.read(); letter != -1; letter = in.read()) {
				content += (char)letter;
			}
			in.close();
			content = content.toLowerCase();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found :(");
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// the main container
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// the inner container
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder("File Analysis"));
		
		// text container
		JTextArea displayarea = new JTextArea();
		displayarea.setEditable(false);
		
		// create and add listeners to the buttons
		JButton freqButton = new JButton("Letter Frequencies");
		freqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				int[] freq = calcFrequencies();
				output = "\n   Letter frequencies in " + f.getName()+": \n";
				for (int i = 0; i < freq.length; i++) 
					output += "\n      "+(char)(i+97)+": " +freq[i];
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton numWordsButton = new JButton("Number of Words in File");
		numWordsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Number of words in "+f.getName()+": " + numWords();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton numLinesButton = new JButton("Number of Lines in File");
		numLinesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Number of lines in "+f.getName()+": " + numLines();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton mostCommonLetterButton = new JButton("Most Common Letter");
		mostCommonLetterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Most common letter in "+f.getName()+": "+mostCommonLetter();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton mostCommonWordButton = new JButton("Most Common Word");
		mostCommonWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Most common word in "+f.getName()+": "+mostCommonWord();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton tenMostCommonButton = new JButton("10 Most Common Words");
		tenMostCommonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				String[] common = tenMostCommonWords();
				output += "\n   10 most common words in "+f.getName()+
						" (of at least length 5):\n";
				for (int i = 0; i < common.length; i++)
					output += "\n      "+(i+1)+". "+common[i];
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton longestSentenceButton = new JButton("Longest Sentence");
		longestSentenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Longest sentence in "+f.getName()+":";
				output += "\n\n      "+longestSentence();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayarea.setText("\n   Currently working in "+f.getName()+".");
			}
		});
		
		JButton percentVowelsButton = new JButton("Percent Vowels");
		percentVowelsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Vowels make up "+percentVowels() +
						" of letters in "+f.getName()+".";
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		
		JButton longestWordButton  = new JButton("Longest Word");
		longestWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Longest Word: "+longestWord();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		
		// add a scroll bar to the text area
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400,475));
		panel.add(scroll);
		
		// create three containers for the three button rows 
		JPanel innerPanel2 = new JPanel(),innerPanel3 = new JPanel(),
				innerPanel4 = new JPanel();
		innerPanel2.add(freqButton);
		innerPanel2.add(numWordsButton);
		innerPanel2.add(numLinesButton);
		innerPanel3.add(mostCommonLetterButton);
		innerPanel3.add(mostCommonWordButton);
		innerPanel3.add(tenMostCommonButton);
		innerPanel4.add(percentVowelsButton);
		innerPanel4.add(longestSentenceButton);
		innerPanel4.add(longestWordButton);
		innerPanel4.add(clearButton);
		panel.add(innerPanel2);
		panel.add(innerPanel3);
		panel.add(innerPanel4);
		
		// final setup on the frame
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	
		// beginning text display
		displayarea.setText("\n   Currently working in "+f.getName()+".");
	}
	
	public static void main(String[] args) {
		new FileAnalysis();
	}
}