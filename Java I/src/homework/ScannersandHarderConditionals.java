package homework;
import java.util.Scanner;
public class ScannersandHarderConditionals {
	Scanner input = new Scanner(System.in);
	public void fourDigits() {
		System.out.println("Enter the first integer");
		int one = input.nextInt();
		System.out.println("Enter the second integer");
		int two = input.nextInt();
		System.out.println("Enter the third integer");
		int three = input.nextInt();
		System.out.println("Enter the fourth integer");
		int four = input.nextInt();
		System.out.println(four + "" + three + "" + two + "" + one);
	}
	public void stringAndTwoNumbers() {
		System.out.println("Enter the first integer");
		int one = input.nextInt();
		System.out.println("Enter the second integer");
		int two = input.nextInt();
		System.out.println("Enter the string");
		String operator = input.next();
		if (operator.equals("+")) {
			System.out.println(one + two);
		}
		else if (operator.equals("-")) {
			System.out.println(one - two);
		}
		else if (operator.equals("*")) {
			System.out.println(one*two);
		}
		else if (operator.equals("/")) {
			System.out.println(one/two);
		}
		else if (operator.equals("%")) {
			System.out.println(one%two);
		}
		else {
			char numChar = (char) one;
			char numChar2 = (char) two;
			System.out.println(operator + numChar + "" + numChar2);
		}
	}
	public void touchdowns() {
		System.out.println("Enter the number of touchdowns");
		int touchdowns = input.nextInt();
		System.out.println("Enter the number of field goals");
		int fieldGoals = input.nextInt();
		System.out.println("Enter the total score");
		int totalScore = input.nextInt();
		int possibleTouchdowns=totalScore/7;
		int differenceInTouchdowns=touchdowns-possibleTouchdowns;
		if (differenceInTouchdowns<0) {
			System.out.println("It is not possible");
			return;
		}
		totalScore=totalScore-(possibleTouchdowns*7);
		int possibleFieldGoals=totalScore/3;
		int differenceInFieldGoals=fieldGoals-possibleFieldGoals;
		if (differenceInFieldGoals<0 || totalScore%(possibleFieldGoals*3)!=0) {
			System.out.println("It is not possible");
			return;
		}
		System.out.println("Yes, it is possible");
	}
	public void largestDigit() {
		System.out.println("Enter a number");
		int number = input.nextInt();
		int onesDigit=number%10;
		number=number/10;
		int tensDigit=number%10;
		number=number/10;
		int hundredsDigit=number%10;
		if (onesDigit>tensDigit) {
			if (onesDigit>hundredsDigit) {
				System.out.println(onesDigit);
			} else {
				System.out.println(hundredsDigit);
			}
		}
		else if (tensDigit>hundredsDigit) {
			System.out.println(tensDigit);
		} else {
			System.out.println(hundredsDigit);
		}
	}
	public static void main (String [] args) {
		ScannersandHarderConditionals runner = new ScannersandHarderConditionals();
		//System.out.println("Problem #1: Enter 4 numbers and they will be printed together as a complete number.");
		//runner.fourDigits();
		//System.out.println("Problem #2: Enter 2 numbers and a string and if the string is a mathematical operator then the operator will be used on the two numbers.");
		//runner.stringAndTwoNumbers();
		System.out.println("Problem #3: Enter touchdowns, field goals, and the total score. If there is a way to reach the total score exactly with the given touchdowns and field goals then it will print yes, otherwise no. Note that not all of the touchdowns and field goals have to be used, just enough of them.");
		runner.touchdowns();
		//System.out.println("Problem #4: Enter a single number. It will print out the largest digit. Assume that the largest value given will be 999.");
		//runner.largestDigit();
		//System.out.println("Thanks for viewing my code!");
	}
}
