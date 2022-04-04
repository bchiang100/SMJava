package classwork;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionarySorter {
	
	public String mode = "insertion";	
	public String fileName = "wordsShuffledSmaller.txt";
	
	public void selectionSort(List<String> words) {
		
		for (int i = 0; i < words.size() - 1; i++)
		{
		int min = i;
		for (int j = i+1; j < words.size(); j++)
		if (words.get(j).compareTo(words.get(min)) < 0)
		min = j;
		String temp = words.get(min);
		words.set(min, words.get(i));
		words.set(i, temp);
		}
		System.out.println(words);
	}
	
	public void insertionSort(List<String> words) {
		
        for (int i = 1; i < words.size(); ++i) {
            String key = words.get(i);
            int j = i - 1;
 
        
            while (j >= 0 && words.get(i).compareTo(key) > 0) {
            	words.set(j+1, words.get(j));
                j--;
            }
            words.set(j+1, key);
        }
        System.out.println(words);
	}

	public void mergeSort(List<String> words) {	// starter for your recursion
		mergeSort(words, 0, words.size()-1);
	}
	
	public void mergeSort(List<String> words, int start, int end) {
		int mid = (end - start)/2;
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (int i = 0; i < mid; i++) {
			list1.add(words.get(start + i));
		}
		for (int i = 0; i < end - mid; i++) {
			list2.add(words.get(end + i + 1));
		}
		
	}
	
	public void merge(List<String> words, int start, int mid, int end) {

		if (start < end) {
            // Find the middle point
            int mid2 =start + (end-start)/2;
  
            // Sort first and second halves
            mergeSort(words, start, mid2);
            mergeSort(words, mid2 + 1, end);
  
            // Merge the sorted halves
            merge(words, start, mid2, end);
        }

	}
	
	public static void main(String[] args) throws IOException {
		new DictionarySorter();
	}
	public DictionarySorter() throws IOException{
		// generates the word list from the dictionary file
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		List<String> words = new ArrayList<String>();
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			words.add(line.trim());
		}
		in.close();
		long startTime = System.currentTimeMillis();
		if (mode.equals("selection"))
			selectionSort(words);
		else if (mode.equals("insertion"))
			insertionSort(words);
		else
			mergeSort(words);
		System.out.println("runtime: " + (System.currentTimeMillis() - startTime));
		
		BufferedWriter out = new BufferedWriter(new FileWriter("wordsSorted.txt"));
		for (String s : words)
			out.write(s + "\n");
		out.close();
	}
}