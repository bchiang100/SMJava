package homework;
import java.util.ArrayList;


public class CommonListAlgorithms {
	public void average(ArrayList<Integer> list) {
		double average = 0;
		for (int num : list) {
			average+=0;
		}
		average/=list.size();
		System.out.println(average);
	}
	public void minumum(ArrayList<Integer> list) {
		int min = list.get(0);
		for (int num : list) {
			if (min > num) {
				min = num;
			}
		}
		System.out.println(min);
	}
	public void Fibonacci(int n) {
		ArrayList<Integer> fib = new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		if (n > 2) {
			for (int i = 2; i < n; i++) {
				fib.add(fib.get(i-1) + fib.get(i - 2));
			}
			System.out.println(fib);
		}
		if (n == 1) {
			fib.remove(1);
			System.out.println(fib);
		}
		if (n == 2) {
			System.out.println(fib);
		}
	}
	public void factors(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n/2; i++) {
			if (n % i == 0) {
				list.add(i);
			}
		}
		System.out.println(list);
	}
	public int binarySort(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		int start = 0;
		int end = list.size() - 1;
			while (start <= end) {
				int mid = (start + end)/2;
				System.out.println(start + " " + mid + " " + end);
				if (list.get(mid) == n) {
					
					return n;
				}
				if (list.get(mid) < n) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			
			return -1;
	}
	public static void main(String [] args) {
		CommonListAlgorithms runner = new CommonListAlgorithms();
		runner.Fibonacci(1);
		runner.factors(134);
		System.out.println(runner.binarySort(6));
	}
}
