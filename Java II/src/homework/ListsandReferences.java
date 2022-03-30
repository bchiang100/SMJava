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
	public void average(ArrayList<Double> A) {
		double average = 0;
		ArrayList<Double> answer = new ArrayList<Double> ();
		for (int i = 0; i < A.size(); i++) {
			average += A.get(i);
		}
		average /= A.size();
		answer.add(average);
	}
	public static void main(String [] args) {
		ListsandReferences runner = new ListsandReferences();
		ArrayList<Character> test = new ArrayList<Character> ();
		test.add('h');
		test.add('e');
		test.add('l');
		test.add('l');
		test.add('o');
		runner.concatenate(test); 
	}
}
