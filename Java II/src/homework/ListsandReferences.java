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
		ArrayList<Double> answer = new ArrayList<Double> ();
		int index = 0;
		while (answer.size() != A.size()) {
			double average = 0;
			for (int i = 0; i < A.size(); i++) {
				average += A.get(i);
			}
			average /= A.size();
			answer.add(average);
			A.remove(index);
			A.add(index, average);
			index++;
		}
		System.out.println(answer);
	}
	public void add(ArrayList<Integer> A) {
		ArrayList<Integer> answer = new ArrayList<Integer> ();
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < i + 1 || j == 0; j++) {
				answer.add(A.get(j));
			}
		}
		System.out.println(answer);
	}
	public static void main(String [] args) {
		ListsandReferences runner = new ListsandReferences();
		ArrayList<Character> test1 = new ArrayList<Character> ();
		test1.add('h');
		test1.add('e');
		test1.add('l');
		test1.add('l');
		test1.add('o');
		runner.concatenate(test1); 
		ArrayList<Double> test2 = new ArrayList<Double> ();
		test2.add(3.0);
		test2.add(6.0);
		test2.add(1.0);
		test2.add(8.0);
		test2.add(19.0);
		runner.average(test2);
		ArrayList<Integer> test3 = new ArrayList<Integer> ();
		test3.add(3);
		test3.add(1);
		test3.add(4);
		test3.add(2);
		runner.add(test3);
	}
}
