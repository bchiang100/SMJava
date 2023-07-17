package classwork;

import java.util.HashMap;
import java.util.Scanner;
public class peerreviewtesting {
    public static HashMap<Integer, Integer>  fibo = new HashMap<Integer, Integer>();
    
    public static int fib(int n) {
        fibo.put(0,0);
        fibo.put(1,1);
        fibo.put(2,1);
        fibo.put(n, fib(n-2)+fib(n+1));
        return fibo.get(n);
    }
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.println(fib(input));

    }
}