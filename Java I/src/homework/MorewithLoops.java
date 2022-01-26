package homework;
import java.util.Scanner;

public class MorewithLoops {
	Scanner input = new Scanner(System.in);
	//linear runtime, definite loop
	public void factorial() {
		System.out.println("Enter a number");
		int iterations=input.nextInt();
		int factorial=1;
		for (int i=iterations;i>0;i--) {
			factorial=factorial*i;
		}
		System.out.println(iterations + "! is " + factorial);
	}
	//constant runtime, indefinite loop
	public void keepPlaying() {
		String play="yes";
		while (play.equals("yes")) {
			System.out.println("Do you want to keep playing?");
			play=input.next();
		}
		System.out.println("game over");
	}
	//linear runtime, definite loop
	public void lessThanDivisible() {
		System.out.println("Enter a number");
		int number=input.nextInt();
		int answer;
		for(int i=1;i<number;i++) {
			if (number%i==0) {
				System.out.println(i);
			}
		}
	}
	//quadratic runtime, indefinite loop
	public void greatestCommonDivisor() {
		System.out.println("Enter the first number");
		int number1=input.nextInt();
		System.out.println("Enter the second number");
		int number2=input.nextInt();
		for (int i=1;i<number1;i++) {
			for (int j=1;j<number2;j++) {
				if (number1%i==0 && number2%j==0 && i==j) {
					System.out.println(i);
				}
			}
		}
	}
	//linear runtime, indefinite loop
	public void leastCommonMultiple() {
		System.out.println("Enter the first number");
		int number1=input.nextInt();
		System.out.println("Enter the second number");
		int number2=input.nextInt();
		for (int i = Math.max(number1, number2);i<=number1*number2;i+=Math.max(number1, number2)) {
			if (i%Math.min(number1, number2)==0) {
				System.out.println(i);
				break;
			}
		}
	}
	//linear runtime, definite loop
	public void prime() {
		System.out.println("Enter a number");
		int number=input.nextInt();
		int x=0;
		for (int i = 2;i<number;i++) {
			if (number%i==0) {
				x++;
			}
		}
		if (x==0) {
			System.out.println("The number is a prime");
		} else {
			System.out.println("The number is not a prime");
		}
	}
	public static void main (String [] args) {
		MorewithLoops runner = new MorewithLoops();
		runner.factorial();
		runner.keepPlaying();
		runner.lessThanDivisible();
		runner.greatestCommonDivisor();
		runner.leastCommonMultiple();
		runner.prime();
	}
}
