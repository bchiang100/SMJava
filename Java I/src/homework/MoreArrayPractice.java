package homework;

import java.util.Arrays;

public class MoreArrayPractice {
	public String[] PosorNeg (int arr[]) {
		
		String arr2[] = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]<0) {
				arr2[i] = "neg";
			} else {
				arr2[i] = "pos";
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr2;
	}
	public Boolean CharandArray (char arr[], char c) {
		Boolean p = false;
		for (int i = 0; i < arr.length; i++) {
			if (c == arr[i]) {
				p = true;
			}
		}
		System.out.println(p);
		return p;
		
	}
	public void StringandArray(String arr[], String s) {
		int i;
		int answer = -1;
		for (i = 0; i < arr.length; i++) {
			if (s == arr[i]) {
				
				answer = i;
			}
		}
		System.out.println(answer);
		}
	public void minValue (Double arr[]) {
		int i = 0;
		double temp = arr[0];
		for (i = 0; i < arr.length-1; i++) {
			if (temp > arr[i+1]) {
				temp = arr[i+1];
			}
		}
		System.out.println(temp);
	}
	public void sumOfArrays(int arr[], int arr2[]) {
		int answer[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i] + arr2[i];
		}
		System.out.println(Arrays.toString(answer));
	}
	public void commonNumbers(int arr[], int arr2[]) {
		int answer[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr[i] == arr2[j]) {
					answer[i] = arr[j];
				}
			}
		}
		System.out.println(Arrays.toString(answer));
	}
	//needs revision
	public void uniqueNumebrs(int arr[]) {
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					continue;
				}
				if (temp == arr[j]) {
					System.out.println(temp);
				}
			}
			temp = arr[i];
		}
	}
	public void arrayToDigit(int num) {
		int count = 1;
		int temp = num;
		while (temp / 10 >= 1) {
			count+=1;
			temp/=10;
		}
		int arr[] = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = num%10;
			num/=10;
		}
		for (int i = 0; i < arr.length/2; i ++) {
			int temp2 = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-1-i] = temp2;
			
		}
		System.out.println(Arrays.toString(arr));
	}
	public void noDuplicates(int arr[]) {
		//In this problem I plan to append all unique numbers to a single number, then convert that number into a list
		
		int num = arr[0];
		num*=10;
		System.out.println(num);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					continue;
				} else {
					num+=arr[j];
					num*=10;
				}
				System.out.println(num);
			}
		
		}
		//I ran into a problem where the unique numbers kept being added and I couldn't find a way to remove the excess numbers
		//Below I tried to divide the number by the 10 to the power of the array's length to only get 1 unique number set but that didn't work either
		num=num/(int)(Math.pow(10,arr.length));
		System.out.println(num);
	}
		
	
	public static void main (String [] args) {
		MoreArrayPractice runner = new MoreArrayPractice();
		System.out.println("Problem #1");
		runner.PosorNeg(new int[] {1,-2,3});
		System.out.println("Problem #2");
		runner.CharandArray(new char[] {'a', 'b','c'} , 'c');
		System.out.println("Problem #3");
		runner.StringandArray(new String[] {"hah","hg", "lol"}, "hi");
		System.out.println("Problem #4");
		runner.minValue(new Double[] {3.0, 4.2, 5.4, 1.0, 8.2});
		System.out.println("Problem #5");
		runner.sumOfArrays(new int[] {1, 4, 5}, new int[] {4 , 6, 2});
		System.out.println("Problem #6");
		runner.commonNumbers(new int[] {4, 5, 7}, new int[] {3, 7, 4});
		System.out.println("Problem #7");
		runner.uniqueNumebrs(new int[] {1, 2, 3, 3, 6, 3, 7, 4, 1});
		System.out.println("Problem #8");
		runner.arrayToDigit(434922);
		System.out.println("Problem 9 (Look at comments in code)");
		runner.noDuplicates(new int[] {4, 2, 6, 3});
	}
}

