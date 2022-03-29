package homework;

import java.util.ArrayList;

public class ListsandReferences {
	public void concatenate(ArrayList<Character> A) {
		String answer = "";
		for (int i = 0; i < A.size(); i++) {
			answer += A.get(i);
		}
		System.out.println(answer);
	}
	public static void main(String [] args) {
		ListsandReferences runner = new ListsandReferences();
		runner.concatenate(new ArrayList<String> {'h','e','l','l','o'}); 
	}
}
