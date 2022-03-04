package classwork;
import java.util.ArrayList;

public class ListStuff {
	ArrayList<Integer> myList = new ArrayList<Integer>();
	myList.add(5);
	myList.add(4);
	
	myList.add(0, 7);
	
	myList.remove(1);
	System.out.println(myList);

}
