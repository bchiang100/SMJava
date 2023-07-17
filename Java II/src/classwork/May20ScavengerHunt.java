package classwork;

import java.util.ArrayList;

public class May20ScavengerHunt {
	public void mystery(int n) {
		ArrayList<String> mys = new ArrayList<String>();
		
		
	}
	
	public static int gcd(int a, int b) {
		return a%b==0 ? b : gcd(b, a%b);
	}
	public static void main(String [] args) {
		System.out.println(gcd(24, 5));
	}
}
