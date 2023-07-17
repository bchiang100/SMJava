package homework;
import java.util.Scanner;
public class StartingwithLoops {
	Scanner input = new Scanner(System.in);
	//The method below is an indefinite loop
	public void allInclusiveNumbers() {
		System.out.println("Enter the first integer");
		int num1=input.nextInt();
		System.out.println("Enter the second integer");
		int num2=input.nextInt();
		int difference=num2-num1;
		if (difference<0) {
			difference = difference * -1;
		}
		int x=0;
		if (num1-difference>0) {
			while (x<=num1-num2) {
				System.out.println(num2+x);
				x++;
			}
		}
		if (num2-difference>0) {
			while (x<=num2-num1) {
				System.out.println(num1+x);
				x++;
			}
		}
	}
	//The method below is a definite loop (it will only run 6 times)
	public void exponential() {
		System.out.println("Enter the first double");
		int num1=input.nextInt();
		System.out.println("Enter the second double");
		int num2=input.nextInt();
		int x=0;
		while (x<6) {
			System.out.println(num2*(Math.pow(num1, x)));
			x++;
		}
	}
	//The method below is an indefinite loop
	public void squareRoot() {
		System.out.println("Please enter an integer");
		int num=input.nextInt();
		int x=0;
		while (x<=num/2) {
			if (x*x==num) {
				System.out.println("Yes, the square root of that number is " + x);
			}
			x++;
		}
	}
	//The method below is an indefinite loop
	public void enterNInputs() {
		System.out.println("Please enter the amount of numbers you want to enter");
		int n=input.nextInt();
		int numInput;
		int x=1;
		int largestNum=0;
		while (x<=n) {
			System.out.println("Enter integer number " + x);
			numInput=input.nextInt();
			if (numInput>largestNum) {
				largestNum=numInput;
			}
			x++;
		}
		System.out.println(largestNum);
	}
	//I didn't really get to finish this challenge, but essentially I tried to make a factorial "function" with only while loops and then using it in the taylor series expansion.
	public void taylorSeries() {
		System.out.println("What is your x?");
		int num=input.nextInt();
		System.out.println("Enter accuracy of Taylor expansion");
		int accuracy=input.nextInt();
		int x=0;
		int factorial=1;
		double total=0;
		int iteration = 1;
		int largestFactorial=1;
		while (x<accuracy) {
			while (iteration<=accuracy) {
				System.out.println(largestFactorial);
				factorial=factorial*largestFactorial;
				largestFactorial=largestFactorial*2+1;
				
				iteration++;
			}
			//for (int i=accuracy;i>0;i--) {
				//factorial=factorial*i;
				//System.out.println(factorial);
			//}
			total=total+(Math.pow(-1, x+1)*((Math.pow(num, x))/iteration));
			x++;
			//System.out.println(total);
		}
		total=total*-1;
		System.out.println(total);
		
	}
	public static void main(String [] args) {
		StartingwithLoops runner = new StartingwithLoops();
		runner.allInclusiveNumbers();
		runner.exponential();
		runner.squareRoot();
		runner.enterNInputs();
		runner.taylorSeries();
 }
}
