package homework;

import java.util.Arrays;

public class MorewithStrings {
	
	public void twoLetters(String str) {
		System.out.println(str.substring(1, 2).equals(str.substring(str.length()-1, str.length())));
	}
	
	public void containedByFirstString(String str1, String str2) {
		for (int i = 0; i < str2.length(); i++) {
			if (str1.contains(str2.substring(i, i + 1))) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	
	public void splitInArray(String str) {
		System.out.println(Arrays.toString(str.split(" ")));
	}
	
	public void howManyWords(String str) {
		String[] A = str.split(" ");
		System.out.println(A.length);
	}

	public void longestBlock(String str) {
		int answer = 1;
		int answer2 = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i-1) == str.charAt(i)) {
				answer+=1;
			}
			if (answer > 1 && answer > answer2 && str.charAt(i-1) != str.charAt(i)) {
				answer2 = answer;
				answer = 1;
			}
		}
		System.out.println(answer2);
	}
	public static void main (String [] args) {
		MorewithStrings runner = new MorewithStrings();
		System.out.println("Problem #1: Two Letters");
		runner.twoLetters("edited");
		System.out.println("Problem #2: Contained by First String");
		runner.containedByFirstString("Hello World", "leg");
		System.out.println("Problem #3: How Many Words?");
		runner.howManyWords("Hello World");
		System.out.println("Split in Array");
		runner.splitInArray("AP CS is for nerds");
		System.out.println("Longest Block");
		runner.longestBlock("iiiasdgbooooww");
	}
}
