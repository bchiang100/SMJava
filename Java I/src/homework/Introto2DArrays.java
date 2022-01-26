package homework;

import java.util.Arrays;

public class Introto2DArrays {
	//problem #1
	//A. 6, B. 1, C. Out of Bounds, D. 3, E. 'k', F. Out of Bounds, G. 113, H. 'k', I. {7, 6}
	public void arraySetup(int n) {
		int count = 0;
		int[][] arr = new int[n+1][n-1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n-1; j++) {
				arr[i][j] = count;
				
				count++;
			}
		}
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	public void howManyColumns(int[][] A) {
		System.out.println(A[0].length + " " + A.length);
	}
	public void containParameters(int n1, int n2, int n3, int n4, int n5, int n6) {
		int[] arr = new int[] {n1, n2, n3, n4, n5, n6};
		int count = 0;
		int[][]arr2 = new int[3][3];   
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j <= i; j++) {
				arr2[i][j] = arr[count]; 
				count++; 
			}
		}
		for (int[] row : arr2) {
			System.out.println(Arrays.toString(row));
		}
	}
	public static void main (String [] args) {
		Introto2DArrays runner = new Introto2DArrays();
		runner.arraySetup(3);
		runner.howManyColumns(new int[][] {{1, 3}, {3, 5}, {2, 1}});
		runner.containParameters(3, 5, 3, 6, 2, 1);
	}
}
