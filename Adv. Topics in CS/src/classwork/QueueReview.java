package classwork;
import java.io.*;
import java.util.*;
public class QueueReview {
	
	static Scanner in=new Scanner(System.in);

	public static void starbucks() {
		Queue<String> q=new LinkedList<>();
		System.out.println("input  in + item name to add item in line   or   out to see next item:");
		boolean endOfDay=false;
		while(!endOfDay) {
			String str=in.nextLine();
			if(str.equals("6pm")) {
				endOfDay = true;
			} else if (str.equals("in")) {
				System.out.println("input the drink/food you want");
			}
			//your code here
		}
		System.out.println("see you tmr");
	}
	
	
	public static void generateBinaryNumber(int n) {
		System.out.println("When n is "+n);
		Queue<String> q=new LinkedList<>();//a queue
		q.add("1");
		while(n>0) {
			String curr = q.poll();
			System.out.println(curr);
			q.add(curr+"0");
			q.add(curr+"1");
			n--;
		}
		
	}
	
	
	public static void zerosAndNines(int n) {
		System.out.println("When n is "+n);
		Queue<String> q=new LinkedList<>();//a queue
		//your code here
	}

	public static void main(String[] args) {
//		starbucks();
		generateBinaryNumber(in.nextInt());
//		zerosAndNines(in.nextInt());
		in.close();
	}
}
