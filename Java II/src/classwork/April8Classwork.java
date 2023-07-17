package classwork;

import java.util.ArrayList;

public class April8Classwork {
	public ArrayList<Integer> relMax(double[] a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i-1] < a[i] && a[i+1] < a[i]) {
				list.add(i);
			}
		}
		System.out.println(list);
		return list;
	}
	
	public static void main(String [] args) {
		April8Classwork runner = new April8Classwork();
		runner.relMax(new double[] {2, 3, 4, 5});
<<<<<<< HEAD
		//testing
=======
>>>>>>> branch 'master' of https://github.com/bchiang100/SMJava
	}
}

