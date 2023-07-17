package homework;

public class IntrotoStrings {
	
	public void printSecondHalf(String str) {
		System.out.println(str.substring(str.length()/2));
	}
	
	public void concatenate(String str1, String str2) {
		System.out.println(str1.substring(1) + str2.substring(1));
	}
	
	public void adverb(String str) {
		if (str.substring(str.length()-2).equals("ly")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
			System.out.println(str.substring(str.length()-2));
		}
	}
	
	public void contains(String str1, String str2) {
		if (str1.contains(str2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	public void reverse(String str) {
		String answer = "";
		char ch;
		for (int i = str.length() - 1; i >= 0; i--) {
			ch = str.charAt(i);
			answer+=ch;
		}
		System.out.println(answer);
	}
	
	public void jumbledWordSquare(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str);
			str = str.substring(1) + str.charAt(0);
		}
	}
	
	public static void main (String [] args) {
		IntrotoStrings runner = new IntrotoStrings();
		System.out.println("Problem #1: Print Second Half");
		runner.printSecondHalf("Hello World");
		System.out.println("Problem #2: Concatenate");
		runner.concatenate("Hello", "World");
		System.out.println("Problem #3: Adverb");
		runner.adverb("Happily");
		System.out.println("Problem #4: Contains");
		runner.contains("Hippo", "Hi");
		System.out.println("Problem #5: Reverse");
		runner.reverse("Hello");
		System.out.println("Problem #6: Jumbled Word Square");
		runner.jumbledWordSquare("Hello");
	}
}
