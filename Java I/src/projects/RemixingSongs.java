package projects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RemixingSongs {

	private String[] lyrics;
	private String fileName = "Faded Lyrics.txt";	// this should match your txt file
	
	private String[] wordsToReplace = new String[] {"where", "are", "you", "now"};	
	private String[] newWords = new String[] {"what", "is", "he", "now"};
	
	public void remix() {
		for (int i = 0; i < lyrics.length; i++) {
			if (lyrics[i].equals("faded")) {
				lyrics[i] = "flying";
			}
			if (lyrics[i].equals("fade")) {
				lyrics[i] = "fly";
			}
			
		}
		System.out.println(Arrays.toString(lyrics));
		System.out.println(lyrics[58]);
	}
	
	// DON'T TOUCH THE BELOW CODE //
	
	public RemixingSongs() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			ArrayList<String> tempLyrics = new ArrayList<String>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				
				String[] words = line.split(" ");
				for (String w : words) {
					tempLyrics.add(w.toLowerCase().replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""));
				}
				tempLyrics.add("\n");
			}
			in.close();
			lyrics = new String[tempLyrics.size()];
			for (int i = 0; i < tempLyrics.size(); i++) {
				lyrics[i] = tempLyrics.get(i);
			}
			

			remix();
			
			if (fileName.substring(fileName.length()-4).equals(".txt")) {
				fileName = fileName.substring(0, fileName.length()-4);
			}
			
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName + "_remixed"));
			
			for (String s : lyrics) {
				out.write(s + (s.equals("\n") ? "" : " "));
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RemixingSongs();
	}
}
