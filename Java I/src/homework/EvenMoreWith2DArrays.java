package homework;

import java.util.Arrays;

public class EvenMoreWith2DArrays {
	public void charToString(char[][] arr) {
		String answer = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer);
	}
	public void nXn (int n) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i][i] = n;
		}
		for (int[] rows : arr) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void triangle (int n) {
		int count = 1; 
		int[][] a = new int[n][];
		for (int i = 0; i < n-1; i++) {
			a[i] = new int[i+1];
			for (int j = 0; j <= i; j++) {
				a[i][j] = count;
				count++;
			}
		} 
	}
	public void zeros(int[][] arr) {
		int[][] arr2 = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length-1; i++ ) {
			for (int j = 0; j < arr[i].length; i+=2) {
				arr2[i][j] = arr[i][j];
				arr2[i][j+1] = 0;
			}
		}
		for (int[] rows : arr2) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void reverse(double[][] arr) {
		double[][] arr2 = new double[arr.length][];
		for (int i = 0; i< arr.length; i++) {
			arr2[i] = new double[arr[i].length];
			for (int j = 0; j < arr[i].length; j++) {
				arr2[i][j] = arr[i][arr[i].length - j - 1];
			}
		}
		for (double[] rows : arr2) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public static void main (String [] args) {
		EvenMoreWith2DArrays runner = new EvenMoreWith2DArrays();
		runner.charToString(new char[][] {{'h', 'e', 'l'}, {'l', 'o'}});
		runner.nXn(3);
		runner.triangle(4);
		runner.zeros(new int[][] {{1,2,3}, {4,5,6}});
		runner.reverse(new double[][] {{1,2,3}, {4,5,6}});
	}
}
