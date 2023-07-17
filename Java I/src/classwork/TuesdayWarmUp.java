package classwork;

public class TuesdayWarmUp {
	int counter = 1;
	int timesTen=10;
	int answer=0;
	public void digits (int x) {
		while (x/timesTen>0) {
			counter+=1;
			timesTen*=10;
		}
		timesTen=10;
		for (int i = 1;i<=counter;i++) {
			answer = x % timesTen;
			System.out.println(answer);
			timesTen*=10;
		}
		System.out.println(answer);
	}
	public void twoParameters(int x, int y) {
		for (int i=1;i<x;i++) {
			System.out.print("X");
			for (int j=1;j<=y;j++) {
				System.out.print("X");
			}
			System.out.println(" ");
		}
	}
	public void factors (int n) {
		
	}
	public static void main (String [] args) {
		TuesdayWarmUp runner = new TuesdayWarmUp();
		runner.digits(128);
		runner.twoParameters(3, 2);
	}
}
