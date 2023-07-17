package homework;

public class FinalArrayProblems {
	public void indexWeightedSum (double[] A) {
		double answer = 0;
		for (int i = 0; i < A.length; i++) {
			answer = answer + A[i] * i;
		}
		System.out.println(answer);
	}
	
	public void stringFromCharacters (char[] A) {
		String answer = "";
		for (int i = 0; i < A.length; i ++) {
			if (A[i] >= 97 && A[i] <= 122) {
				answer+=A[i];
			}
		}
		System.out.println(answer);
	}
	
	public void sumToNum(int[] A, int n) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] + A[i+1] == n) {
				System.out.println("yes");
				break;
			}
		}
	}
	
	public void anagrams(String[] A, String[] B) {
		boolean anagram = false;
		for (int i = 0; i < A.length; i++) {
			anagram = false;
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					anagram = true;
				} 
			}
			if (anagram == false) {
				System.out.println("They are not anagrams");
				break;
			}
		}
		if (anagram == true) {
			System.out.println("They are anagrams");
		}
	}
	
	public static void main (String[] args) {
		FinalArrayProblems runner = new FinalArrayProblems();
		System.out.println("Problem #1");
		runner.indexWeightedSum(new double[] {5.8, 3.1, 2.5});
		System.out.println("Problem #2");
		runner.stringFromCharacters(new char[] {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'});
		System.out.println("Problem #3");
		runner.sumToNum(new int[] {1, 5, 2, 7, 3}, 9);
		System.out.println("Challenge Problem #5");
		runner.anagrams(new String[] {"c", "i", "n", "e", "m", "a"}, new String[] {"i", "c", "e", "m", "a", "n"});
	}
}
