package homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorewithMaps {
	Scanner input = new Scanner(System.in);
	public double stock(HashMap<String, Integer> stonk) {
		while (true) {
			double total = 0;
			System.out.println("Choose a company name");
			String n = input.nextLine();
			if (stonk.get(n) == null) {
				System.out.println("This company is not found, but here is the most valued company");
				double max = 0;
				for (Integer index : stonk.values()) {
					if (index > max) {
						max = index;
					}
				}
				System.out.println(max);
				return max;
			}
			if (!n.equals("average")) {
				System.out.println(stonk.get(n));
			} else {
				for (Integer index : stonk.values()) {
					total+=index;
				}
				total/=stonk.size();
				return total;
			}
		}
	}
	
	public String[] chaintargets(HashMap<String, String> names) {
        System.out.println("Input starting name: ");
        String start = input.nextLine();
        String[] players = new String[names.size()];
        String curr = start;
        int i = 0;
        players[i] = start;
        for (i = 1; i < names.size(); i++) {
            curr = names.get(curr);
            if (curr == start) {
                break;
            }
            players[i] = curr;
        }
        System.out.println(Arrays.toString(players));
        return players;
    }
	
	public String morseCode() {
		String message;
		String translation = "";
		HashMap<String, String> morse = new HashMap<String,String>();
		morse.put("a", ".-");
		morse.put("b", "-...");
		morse.put("c", "-.-.");
		morse.put("d", "-..");
		morse.put("e", ".");
		morse.put("f", "..-.");
		morse.put("g", "--.");
		morse.put("h", "....");
		morse.put("i", "..");
		morse.put("j", ".---");
		morse.put("k", "-.-");
		morse.put("l", ".-..");
		morse.put("m", "--");
		morse.put("n", "-.");
		morse.put("o", "---");
		morse.put("p", ".--.");
		morse.put("q", "--.-");
		morse.put("r", ".-.");
		morse.put("s", "...");
		morse.put("t", "-");
		morse.put("u", "..-");
		morse.put("v", "...-");
		morse.put("w", ".--");
		morse.put("x", "-..-");
		morse.put("y", "-.--");
		morse.put("z", "--..");
		System.out.println("Type your message");
		message = input.nextLine();
		message = message.toLowerCase();
		for (int i = 0; i < message.length(); i++) {
			if (morse.containsKey(message.substring(i, i+1))) {
				translation += morse.get(message.substring(i, i+1));
			}
		}
		System.out.println(translation);
		return translation;
		
		
		
	}
	public static void main(String [] args) {
		MorewithMaps runner = new MorewithMaps();
		HashMap<String, Integer> stock = new HashMap<String, Integer>();
		stock.put("Apple", 82923523);
		stock.put("Meta", 98762342);
		stock.put("Microsoft", 2348276);
		HashMap<String, String> chain = new HashMap<String, String>();
		chain.put("Cooper", "Ryan");
		chain.put("Ryan", "Hanson");
		chain.put("Hanson", "Cooper");
		runner.chaintargets(chain);
		//runner.stock(stock);
		//runner.morseCode();
	}
}
