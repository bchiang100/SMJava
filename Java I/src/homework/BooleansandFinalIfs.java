package homework;
import java.util.Scanner;
public class BooleansandFinalIfs {
	Scanner input = new Scanner(System.in);
	public void binary (int num1, int num2, int num3, int num4, int num5) {
		double answer = ((1*num5)+(2*num4)+(4*num3)+(8*num2)+(16*num1));
		System.out.println((int)answer);
	}
	public void switchStrings() {
		String temp;
		System.out.println("Print the first string.");
		String str1=input.nextLine();
		System.out.println("Print the second string");
		String str2=input.nextLine();
		temp=str1;
		str1=str2;
		str2=temp;
		System.out.println("String one is now " + str1 + " and string two is now " + str2);
	}
	public void remainder(int num) {
		int newNum=num/1000;
		int divisor1=num%10;
		int divisor2=num%100;
		divisor2=divisor2/10;
		int divisor3=num%1000;
		divisor3=divisor3/100;
		System.out.println(newNum%divisor1);
		System.out.println(newNum%divisor2);
		System.out.println(newNum%divisor3);
	}
	public void twoChars(char char1, char char2) {
		if ((char1+char2>97 && char1+char2<122) || (char1+char2>65 && char1+char2<90)) {
			System.out.println(char1+char2);
		} 
		else if (char1+char2<97) {
			System.out.println('a');
		}
		else if (char1+char2>122) {
			System.out.println('z');
		}
		else if (char1+char2<65) {
			System.out.println('A');
		}
		else if (char1+char2>90) {
			System.out.println('Z');
		}
		System.out.println(char1+char2);
	}
	public static void main (String [] args) {
		BooleansandFinalIfs runner = new BooleansandFinalIfs();
		runner.binary(1,0,1,1,1);
		runner.switchStrings();
		runner.remainder(34924);
		runner.twoChars('8', 'f');
	}
}
