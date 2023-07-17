package homework;

public class OperationsWorksheet {
	private void printChar(int x) {
		System.out.println((char)x);
	}
	private void lastDigit(int y) {
		double temp = y;
		int temp2;
		temp=temp/10;
		temp2=(int)temp;
		temp=temp*10;
		temp2=temp2*10;
		temp=temp-temp2;
		System.out.println((int)temp);
	}
	private void average(int num1, int num2) {
		System.out.println((double)(num1 + num2)/2);
	}
	
	public static void main (String [] args) {
		OperationsWorksheet runner = new OperationsWorksheet();
		runner.printChar(97);
		runner.lastDigit(3423);
		runner.average(8, 7);
	}
}
