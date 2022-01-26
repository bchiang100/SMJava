package homework;

public class WarmingBackUpStringProblems {
	public void alphabeticalOrder(String str) {
		boolean check = true;
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) > str.charAt(i+1)) {
				check = false;
			}
		}
		System.out.println(check);
	}
	public String highestGrade(String[] names, int[] grades) {
		int maxI = 0;
		for (int i = 0; i < names.length; i++) {
			if (grades[maxI] > grades[i]) {
				maxI = i;
			}
		}
		return names[maxI];
	}
	public int[] oddPerfectSquares(int n) {
		int arrayLength = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j*j == i && i % 2 == 1) {
					arrayLength+=1;
				}
			}
		}
		int arr[] = new int[arrayLength];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j*j == i && i % 2 == 1) {
					arr[i] = i;
				}
			}
		}
		return arr;
	}
	public String every3(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i+=3) {
			if (i % 2 == 0) {
				newStr += str.substring(i, i+3);
			}
		}
		return newStr;
	}
	public void primeFactorization(int n) {
		Boolean check = false;
		for (int i = 2; i<n; i++) {
			if (n % i == 0) {
				check = true;
				for (int j = 2; j < (i / 2 + 1); i++) {
					if (i % j == 0) {
						check = false;
						break;
					}
				}
				if (check == true) {
					System.out.println(i);
				}
			}
		}
	}
	public static void main (String [] args) {
		WarmingBackUpStringProblems runner = new WarmingBackUpStringProblems();
		runner.alphabeticalOrder("abcde");
		runner.highestGrade(new String[] {"Jon", "Kevin", "Karl"}, new int[] {92, 86, 94});
		runner.oddPerfectSquares(936);
		runner.every3("abcghim");
		runner.primeFactorization(24);
	}
}
