package homework;
import java.util.Scanner;
public class StartingwithArrays {
	Scanner input = new Scanner(System.in);
	public void display(int A[]) {
		for (int i=0;i<A.length;i++)
			System.out.println(A[i]);
	}
	public void combinedPrint(int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = i+1;
		}
		display(A);
	}
	public void swap(int A[]) {
		int temp = A[0];
		A[0] = A[A.length-1];
		A[A.length-1] = temp;
		display(A);
	}
	public void userArray(int n) {
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = input.nextInt();
		}
		display(A);
	}
	public void reverse(int A[]) {
		int temp;
		int count = 1;
		for (int i = 0; i < A.length-2; i++) {
			temp = A[i];
			A[i] = A[A.length-count];
			A[A.length-count] = temp;
			count+=1;
		}
		display(A);
		
	}
	public static void main(String [] args) {
		StartingwithArrays runner = new StartingwithArrays();
		System.out.println("Problem #1");
		runner.display(new int[] {1, 2, 3});
		System.out.println("Problem #2");
		runner.combinedPrint(3);
		System.out.println("Problem #3");
		runner.swap(new int[] {7, 2, 1, 8, 4});
		System.out.println("Problem #4");
		runner.userArray(3);
		System.out.println("Problem #5");
		runner.reverse(new int[] {5, 3, 2});
	}
}
