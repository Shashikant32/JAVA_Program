import java.util.*;
public class Main {
    public static void main(String[] args) {
       Scanner scr = new Scanner(System.in);
        int marks = scr.nextInt();
        // Grading System
        if(marks>90)
        {
            System.out.println("Excellent");
        }else if(marks>80)
        {
            System.out.println("Good");
        }else if(marks>70)
        {
           System.out.println("Fair"); 
        }else if(marks>60)
        {
            System.out.println("Meets Expectations");
        }else
        {
            System.out.println("Below Expectations");
        }
        
    }
}