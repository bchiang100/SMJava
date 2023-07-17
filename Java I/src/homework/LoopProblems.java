package homework;
import java.util.Scanner;
public class LoopProblems {
	private Scanner input = new Scanner(System.in);
	public void average() {
		int currentNum = 0;
		int totalNum = 0;
		int amount = 0;
		while (currentNum != -1) {
			currentNum = input.nextInt();
			if (currentNum != -1) {
				totalNum += currentNum;
				amount++;
			}
		}
		System.out.println(totalNum/amount);
	}
	public void sum(int n) {
		int sum=0;
		for (int i=1;i<=n;i++) {
			sum=sum+i;
			System.out.println(sum);
		}
	}
	public void firstNPowers(double x, int n) {
		for(int i = 1; i <= n; i++) {
			System.out.println(Math.pow(x,  i)+",");
		}
	}
	public void reverseInt(int n) {
		int answer=0;
		while(n>=1) {
			answer=answer*10+(n%10);
			n/=10;
		}
		System.out.println(answer);
	}
	public void decode(int n) {
		int reverse=0;
		int numSegment;
		while(n>=1) {
			reverse=reverse*100+(n%100);
			n/=100;
		}
		while (reverse%100>0) {
			numSegment=reverse%100;
			System.out.print((char)numSegment);
			reverse/=100;
		}
	}
	public static void main(String [] args) {
		LoopProblems runner = new LoopProblems();
		runner.sum(5);
		runner.firstNPowers(0, 0);
		runner.reverseInt(12345);
		runner.sum(0);
		runner.decode(656770);
	}
}
