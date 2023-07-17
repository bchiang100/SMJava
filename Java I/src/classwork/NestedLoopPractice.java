package classwork;
public class NestedLoopPractice {
	//constant runtime
	public void alphabet() {
		for (int i = 65;i<=90;i++) {
			System.out.println((char)i);
		}
	}
	//quadratic runtime
	public void multiplicationTable() {
		for (int i = 1;i<=12;i++) {
			for (int j = 1;j<=12;j++ ) {
				System.out.print(i*j + " ");
			}
			System.out.println("");
		}
	}
	//linear runtime 2n?
	public void primeGenerator(int x) {
		int counter=0;
		int i=0;
		int j=0;
		for (i=1; i<=x;i++) {
			counter=0;
			for (j=i;j>=1;j--) {
				if (i%j==0) {
					counter+=1;
				}
			}
			if (counter==2) {
				System.out.println(i);
			}
		}
		
	}
	//constant runtime
	public void stars(int n) {
		for (int i=0; i<n;i ++) {
			System.out.println("X");
		}
	}
	public static void main(String [] args) {
	NestedLoopPractice runner = new NestedLoopPractice();
	System.out.println("Welcome to my code!");
	System.out.println("Problem #1: Alphabet");
	runner.alphabet();
	System.out.println("Problem #2: Multilication Table");
	runner.multiplicationTable();
	System.out.println("Problem #3: Prime Generator");
	runner.primeGenerator(12);
	System.out.println("Problem #4: Stars");
	runner.stars(13);
	System.out.println("Challenge Problem: Pascal's Triangle");
	System.out.println("I did not manage to solve this probelem, but I would make a separate method to find the combinatoric value for each triangle number (meaning that I will have to make another method to find the factorial of a number) and then I will make a for loop with a nested for loop to put the numbers in order");
 }
}
