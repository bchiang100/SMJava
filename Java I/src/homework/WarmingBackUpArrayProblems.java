package homework;

import java.util.Arrays;

public class WarmingBackUpArrayProblems {
	
	public void printParameter(String[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	
	public void trimList(int[] A) {
		int[] answer = new int[2];
		int biggestTemp = A[0];
		int smallestTemp = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > biggestTemp) {
				biggestTemp = A[i];
 			}
			if (A[i] < smallestTemp) {
				smallestTemp = A[i];
			}
		}
		answer[0] = smallestTemp;
		answer[1] = biggestTemp;
		System.out.println(Arrays.toString(answer));
	}
	
	public void fibonacci(int n) {
		int[] A = new int[n];
		for  (int i = 0; i < n; i ++) {
			if (i == 0 || i == 1) {
				A[i] = 1;
				continue;
			}
			A[i] = A[i-1] + A[i-2];
		}
		System.out.println(Arrays.toString(A));
	}
	
	public void divisibleByAhead(int[] A) {
		String[] answer = new String[A.length-1];
		for (int i = 1; i < A.length; i++) {
			System.out.println(i);
			if (A[i] % A[i-1] == 0) {
				answer[i-1] = "yes";
			}
			else {
				answer[i-1] = "no";
				}
			}
		System.out.println(Arrays.toString(answer));
		}
	
	public void risingAverage(int A[]) {
		int j;
		int[] answer = new int[A.length];
		for (int i : answer) {
			answer[i] = 0;
		}
		for (int i = 0; i < A.length; i++) {
			for (j = 0; j <= i; j++) {
				answer[i]+= A[j];
			}
			answer[i] = answer[i] / (i+1);
		}
		System.out.println(Arrays.toString(answer));
	}
	
	public void shiftArray (String[] A, int n) {
		int j = 0;
		String[] answer = new String[A.length];
		for (int i = 0; i < A.length; i++) {
			if (i+n<A.length) {
				answer[i+n] = A[i];
			} else {
				answer[j] = A[i];
				j+=1;
			}
		}
		System.out.println(Arrays.toString(answer));
	}
	
	public void dotProduct(int[] A, int[] B) {
		int answer = 0;
		if (A.length != B.length) {
			System.out.println("Please make sure that array A and array B have the same length");
		}
		for (int i = 0; i < A.length; i++) {
			answer = answer + (A[i] * B[i]);
		}
		System.out.println(answer);
		
	}
	
	public static void main (String [] args) {
		WarmingBackUpArrayProblems runner = new WarmingBackUpArrayProblems();
		System.out.println("Easy: #1");
		runner.printParameter(new String[] {"hello", "how", "are", "you"});
		System.out.println("Medium: #1");
		runner.trimList(new int[] {4, 2, 5, 1});
		System.out.println("Medium: #2");
		runner.fibonacci(10);
		System.out.println("Medium: #3");
		runner.divisibleByAhead(new int[] {1, 2, 4, 8, 9, 3});
		System.out.println("Hard: #1");
		runner.risingAverage(new int[] {4, 6, 2, 12});
		System.out.println("Hard: #2");
		runner.shiftArray(new String[] {"I", "love", "C", "S"}, 2);
		System.out.println("Hard: #3");
		runner.dotProduct(new int[] {5, 3, 1}, new int[] {8, 4, 7});
	}
}
