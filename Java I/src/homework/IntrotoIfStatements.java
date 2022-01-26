package homework;

public class IntrotoIfStatements {
	public void posOrNeg(int number) {
		if (number > 0) {
			System.out.println("Yes");
		}
		else if (number < 0) {
			System.out.println("No");
		} else {
			System.out.println("The integer is zero");
		}
	}
	public void evenOrOdd (int number2) {
		if (number2 % 2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}
	public void upperOrLower (char number3) {
		if (65<=number3 && number3<=90) {
			System.out.println("uppercase");
		}
		else if (97<=number3 && number3<=122) {
			System.out.println("lowercase");
		} else {
			System.out.println("neither");
		}
	}
	public void multipleOf10 (int number4) {
		if (number4 % 10 == 0) {
			System.out.println("It is a multiple of 10");
		} else {
			System.out.println("It is not a multiple of 10");
		}
	}
	public void biggestOfThree (double number5, double number6, double number7) {
		if (number5 > number6) {
			if (number5 > number7) {
				System.out.println(number5);
			} else {
				System.out.println(number7);
			}
		}
		if (number6 > number5) {
			if (number6 > number7) {
				System.out.println(number6);
			} else {
				System.out.println(number7);
			}
		}
	}
	public void wholeNumber (double number) {
		number = number * 10;
		if (number % 10 == 0) {
			System.out.println("The number is a whole number");
		} else {
			System.out.println("The number is not a whole number");
		}
	}
	public static void main (String [] args) {
		IntrotoIfStatements tester = new IntrotoIfStatements();
		tester.posOrNeg(-7);
		tester.evenOrOdd(28);
		tester.upperOrLower('h');
		tester.multipleOf10(5340);
		tester.biggestOfThree(34,37,10);
		tester.wholeNumber(37.3);
	}
}
