package homework;

public class ImportantArrayAlgorithms {
	ImportantArrayAlgorithms runner = new ImportantArrayAlgorithms();
	public static int problem1(int[] A) {
		int temp = A[0];
		for (int i = 1; i<A.length; i++) {
			if (temp < A[i]) {
				temp = A[i];
			}
		}
		return temp;
		
	}
	public static String reverse(int A[]) {
		int temp;
		int count = 1;
		for (int i = 0; i < A.length-2; i++) {
			temp = A[i];
			A[i] = A[A.length-count];
			A[A.length-count] = temp;
			count+=1;
		}
		return A.toString();
		
		
	}
	public static double average(int [] arr) {
		double sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum/arr.length;
	}
	public static char[] merge(char[] arr1, char[] arr2) {
		char[] newArr = new char[arr1.length + arr2.length];
		for (int i = 0; i<arr1.length; i++) {
			newArr[i] = arr1[i];
		}
		for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
			newArr[i] = arr2[i-arr1.length];
		}
		return newArr;
	}
	public static void main(String [] args) {
		int[] arr = new int[] {1, 12 ,9};
		int [] arr2 = new int[] {1,2,3,4};
		char[] ans = merge(new char[] {'e', 'h'}, new char[] {'j', 'l', 'y'});
		System.out.println(problem1(arr));
		System.out.println((arr2));
		//System.out.println(Arrays.toString(ans));
	
	}
}
