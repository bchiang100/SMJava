package homework;
import java.util.ArrayList;
public class MoreListAlgorithms {
	public void randomNumbers(int n, int x) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add((int)((Math.random() * 2 * x) - x));
		}
		System.out.println(list);
	}
	public void separate() {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(-34);
		numList.add(300);
		numList.add(-12);
		ArrayList<Integer> negativeNum = new ArrayList<Integer>();
		for (int i = 0; i < numList.size(); i++) {
			if (numList.get(i) < 0) {
				negativeNum.add(numList.get(i));
				numList.remove(numList.get(i));
			}
		}
		System.out.println(numList);
		System.out.println(negativeNum);
	}
	public void reverse(ArrayList<Double> answer) {
		answer.add(1.3);
		answer.add(2.4);
		answer.add(9.2);
		int count = answer.size()-1;
		for (int i = answer.size() - 1; i >= 0; i--) {
			answer.add(answer.get(i));
			answer.remove(answer.get(count));
			count--;
		}
		System.out.println(answer);
	}
 	public static void main(String [] args) {
		MoreListAlgorithms runner = new MoreListAlgorithms();
		runner.randomNumbers(4, 10);
		runner.separate();
		runner.reverse(new ArrayList<Double> ());
		//Yes, a list still needs to be returned otherwise there will be an error (unless you set the return value as void)
	}
}
