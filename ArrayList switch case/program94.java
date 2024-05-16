import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws Throwable{
        //Switch Case Problem 2
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        switch(N)
             {
                 case 12:
                     System.out.println(  "I am even");
                     break;
                case 13:
                     System.out.println(  "I am prime");
                     break;
                 case 25:
                     System.out.println(  "I am odd");
                     break;    
                 default:
                     System.out.println( "I am just a number");
             }
    }
}