package classwork;
public class SA4 {
	
	public void distance(double x1, double y1, double x2, double y2) {
		double dist;
		dist=Math.pow(Math.pow((y2-y1), 2) + Math.pow((x2-x1), 2), 1.0/2);
		System.out.println(dist);
	}
	
	public void quadratic(double a, double b, double c) {
		double solution1;
		double solution2;
		solution1=(-b+Math.pow(Math.pow(b, 2)-(4*a*c), 1.0/2))/(2*a);
		solution2=(-b-Math.pow(Math.pow(b, 2)-(4*a*c), 1.0/2))/(2*a);
		System.out.println("The first solution is " + solution1 + ", and the second solution is " + solution2);
	}
	
	public void charAverage(char char1, char char2) {
		double average;
		average = (char1 + char2)/2;
		System.out.println((char)average);
	}
	
	
	public static void main(String[] args) {
		
		SA4 tester = new SA4();
		
		// prints out the distance between two points
		// output should be 6.83
		tester.distance(1, -2.5, 3.1, 4);
		
		// prints out a solution to y = ax^2 + bx + c, where the 
		// three parameters are a, b, and c. Use the quadratic equation
		// output should be 2 or -2 (challenge: give both solutions)
		tester.quadratic(1, 0, -4);
		
		// prints out the 'average' of two characters
		// output should be 'W'
		tester.charAverage('m', 'A');
	}

}
