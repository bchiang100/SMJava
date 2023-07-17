package classwork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapPractice {
	public static void main(String [] args) {
		HashMap<String, Integer> ages = new HashMap<String,Integer>();
		ages.put("Condy", 3);
		ages.put("Mare", 17);
		ages.put("Joe", 14);
	
		System.out.println(ages.get("Joe"));
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("UserInputs.txt"));
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				System.out.println(line);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
