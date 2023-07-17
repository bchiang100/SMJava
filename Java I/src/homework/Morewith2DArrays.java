package homework;

import java.util.Arrays;

public class Morewith2DArrays {
	public void fillInArray(int n, int m) {
		int count = 1;
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = count;
				
				count++;
			}
		}
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	public void maximum(double[][] A) {
		double max = A[0][0];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] > max) {
					max = A[i][j];
				}
			}
		}
		System.out.println(max);
	}
	public void average(int[][] A) {
		int size = 0;
		double ans = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				size+=1;
				ans+=A[i][j];
			}
		}
		ans/=size;
		System.out.println(ans);
	}
	public void sum(int[][] arr) {
		int arr2[] = new int[arr.length];
		int add = 0;
		for (int i = 0; i < arr.length; i++) {
			add = 0;
			for (int j = 0; j < arr[i].length; j++) {
				add+=arr[i][j];
				arr2[i] = add;
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
	public static void main(String [] args) {
		Morewith2DArrays runner = new Morewith2DArrays();
		runner.fillInArray(3, 5);
		runner.maximum(new double[][] {{3, 4},{5, 3},{34, 1}});
		runner.average(new int[][] {{7, 8},{15, 0},{14, 1}});
		runner.sum(new int[][] {{3, 5, 2}, {8, 3}, {9, 0, 1, 4}});
	}
}
