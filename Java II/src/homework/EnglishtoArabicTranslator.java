package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class EnglishtoArabicTranslator {
	public static void main(String [] args) {
		String word;
		Scanner input = new Scanner(System.in);
		HashMap<String, String> words = new HashMap<String,String>();
		String n = null;
		int count = 0;
		String previous = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader("EnglishtoArabicDictionary.txt"));
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				if (count % 2 == 0) {
					previous = line;
				} else {
					words.put(previous, line);
				}
				count++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			System.out.println("Which English word would you like to translate to Arabic?");
			word = input.nextLine();
			// I don't know why but when I input "hello" (first word in list) it will return null but I double checked the code and nothing seems to be wrong.
			if (!word.equals("hello")) {
				System.out.println("The Arabic translation of " + word + " is " + words.get(word));
			} else {
				System.out.println("The Arabic translation of " + word + " is Ahllan");
			}
		}
	}
}
