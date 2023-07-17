package classwork;
import java.io.*;
import java.util.*;
public class QueueAssessment {
	
	static Scanner in=new Scanner(System.in);

	public static String zerosAndNines(int n) {
		int MAX = 10000;
		System.out.println("When n is "+n);
		Queue<String> q=new LinkedList<>();//a queue
		List<String> qList = new LinkedList<String>();
        q.add("9");
        for (int count = MAX; count > 0; count--) {
            String s1 = q.peek();
            q.remove();
            qList.add(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "9");
        }
        for (int i = 0; i < qList.size(); i++) {
            if (Integer.parseInt(qList.get(i)) % n == 0) {
                return qList.get(i);
            }
        }
        return "";
	}
   

	public static void main(String[] args) {
		System.out.println(zerosAndNines(in.nextInt()));
		in.close();
	}
}