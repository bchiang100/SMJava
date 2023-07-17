package homework;
import java.util.ArrayList;

public class IntrotoLists {
	public void removeEverySecond(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			list.remove(i);
			i++;
		}
		System.out.println(list);
	}
	public ArrayList<String> reverse(ArrayList<String> list) {
		ArrayList<String> answer = new ArrayList<String> ();
		for (int i = list.size() - 1; i >= 0; i--) {
			answer.add(list.get(i));
		}
		return answer;
	}
	public void twice(ArrayList<Double> list) {
		for (int i = 1; i < list.size(); i++) {
			list.set(i, list.get(i) * 2);
		}
		System.out.println(list);
	}
	public ArrayList<Character> lettersOfAlphabet(int n) {
		ArrayList<Character> list = new ArrayList<Character> ();
		for (int i = 0; i < n; i++) {
			if (i % 2 != 0) {
				list.add((char)(i + 97));
			}
			else {
					
				list.add(0, (char)(i + 97));
				
			}
		}
		System.out.println(list);
		return list;
		
	}
	
	public static void main(String [] args) {
		IntrotoLists runner = new IntrotoLists();
		runner.lettersOfAlphabet(5);
	}
}
