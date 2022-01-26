package homework;

public class FarewelltoStrings {
	public void pigLatin(String str) {
		char firstLetter = str.charAt(0);
		str+=firstLetter + "ay";
		str = str.substring(1, str.length());
		System.out.println(str);
	}
	
	public static void main (String [] args) {
		FarewelltoStrings runner = new FarewelltoStrings();
		runner.pigLatin("hello");
	}
}
