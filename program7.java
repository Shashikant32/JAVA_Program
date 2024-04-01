import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Sum of Natural Numbers
       Scanner scr = new Scanner(System.in);
        long num = scr.nextLong();
        long sum=0;
        if(num >0)
        {
            sum=num*(num+1)/2;
        }
		System.out.println(sum);
    }

}