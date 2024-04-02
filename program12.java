import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        //Number of Days
        Scanner scr = new Scanner(System.in);
        int month = scr.nextInt();
        int days ;
        
        if(month == 2)
        {
           days = 28; 
        }else if(month == 4 || month == 6 || month == 9 || month == 11)
        {
            days = 30; 
        }else 
        {
            days = 31;
        }
        System.out.println(days);
    }
}