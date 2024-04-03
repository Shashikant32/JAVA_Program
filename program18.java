import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Print Digits
        Scanner scr = new Scanner(System.in);
        int n =scr.nextInt();
        int t=n;

        //reverse the number
        int rev=0;
        while(t>0)
        {   
                int dig=t%10;
                rev = rev*10+dig;
                
                t=t/10;
        }

        //to print the digits in rev 
    
        while(rev>0){
           int dig = rev%10;
            System.out.println(dig);
            rev=rev/10;
        }

        //to count  trailing zeroes
        t=n;
        int count=0;
        while(t>0){
           int rem=t%10;
            if(rem==0){
                count=count+1;
            }
            else{
                break;
            }
            t=t/10;
        
        }
        //to print triling zeroes
        for(int i=1;i<=count;i++){
            System.out.println(0);
        }
    }
}