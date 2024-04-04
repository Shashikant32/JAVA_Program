import java.io.*;

import java.util.*;

public class Main {
    // Enter a positive integer and increase its value by 5 using for loop.
	static int fun(int n){
       for(int i=0; i<5; i++)
           {
               n++;
           }
        return n;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int result = fun(n);
        System.out.print(result);
    }
}