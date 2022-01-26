package homework;

public class MoreWithNestedLoops {
	int i = 1;
	int j = 1;
	//I did not completely finish this problem because I had a lot of trouble trying to start the next number as number + 1 and ending the last number with ending + 1
	public void loopingBox(int x) {
		for (i=1; i<=x; i++) {
			for (j = 1; j<=x; j++) {
				System.out.print(j + " ");
			}
			j+=1;
		}
	}
	public void triangle(int n) {
		for (int i = 0;i<n;i++) {
			for (int j=0;j<i+1;j++) {
				System.out.print("X");
			}
			System.out.println(" ");
			
		}
	}
	public void whatPower(double x, double y) {
		for (int i = 1; i < y; i++) {
			if (Math.pow(x, i)==y) {
				System.out.println(i);
			}
		}
	}
	public void diamond(int x) {
		int count=x-1;
		for (int i=0;i<x;i++) {
			for (int j=0;j<count;j++) {
				System.out.print(" ");
			}
			for (int k=0;k<=i;k++) {
				System.out.print("* ");
			}
			System.out.println(" ");
			count--;
		}
		count = 0;
		for (int i=x-1;i>0;i--) {
			System.out.print(" ");
			for (int j=0;j<count;j++) {
				System.out.print(" ");
			}
			for (int k=0;k<i;k++) {
				System.out.print("* ");
			}
			System.out.println(" ");
			count++;
		}
	}
	
	public static void main (String [] args) {
		MoreWithNestedLoops runner = new MoreWithNestedLoops();
		System.out.println("Problem #1: Looping Box");
		runner.loopingBox(5);
		System.out.println("Problem #2: Triangle");
		runner.triangle(5);
		System.out.println("Problem #3: What Power?");
		runner.whatPower(2, 8);
		System.out.println("Problem #4: Diamond");
		runner.diamond(4);
	}
}
