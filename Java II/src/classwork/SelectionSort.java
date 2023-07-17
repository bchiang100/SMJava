package classwork;

import java.util.Arrays;

public class SelectionSort {
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	public String encode(String word){
		word = word.toLowerCase();
	    char[] charArr = new char[word.length()];
	    String answer = "";
	    char[] check = new char[word.length()];
	    for (int i = 0; i < word.length(); i++) {
	      charArr[i] = word.charAt(i);
	    }
	    for (int i = 0; i < charArr.length; i++) {
	      for (int j = 1; j < charArr.length; j++) {
	    	if (i == j) {
	    		continue;
	    	}
	        if (charArr[i] == charArr[j]) {
	          check[i] = charArr[i];
	          check[j] = charArr[j];
	          System.out.println(charArr[i] + " is the same as " + charArr[j] + " and i = " + i + " and j = " + j);
	        }
	      }
	      }
	    for (int i = 0; i < check.length; i++) {
	      if (check[i] == 0) {
	        answer += "(";
	      } else {
	        answer += ")";
	      }
	    }
		System.out.println(Arrays.toString(check));
	    System.out.println(answer);
	    return answer;
	  }
	public int nextSmallerNumber(int n) 
	{
	    int answer = 0;
	    int multiply = 10;
	  
	    int count = 0;
	    while (n != 0) {
	      n = n % 10; 
	      n = n / 10; 
	      count++;
	      
	    }
	    count++;
	    int[] arr = new int[count];
	    for (int i = 0; i < arr.length; i++) {
				int min = i;
				for (int j = i+1; j < arr.length; j++) {
					if (arr[j] < arr[min]) {
						min = j;
					}
				}
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
	    
	    System.out.println(Arrays.toString(arr));
	    if (arr[0] == 0) {
	   
	      return -1;
	    }
	    
	    
	      for (int i = arr.length; i > 0; i--) {
	        answer += arr[i] * multiply;
	      }
	      System.out.println(answer);
	      return answer;
	      
	  }
	
	public static void main (String [] args) {
		SelectionSort runner = new SelectionSort();
		//runner.selectionSort(new int[] {5, 0, 8, 3, 1});
		//runner.encode("Success");
		runner.nextSmallerNumber(21);
	}
}
