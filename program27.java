import java.util.*;

public class Main {
    public static void main(String args[]) {
        // Factorial with loop
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
		
        long fact=1;
        for(int i=1; i<=n; i++)
            {
                fact=fact*i;
            }
        System.out.println(fact);
    }
}