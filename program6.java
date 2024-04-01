import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Palindrome Checker
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int num=0;
        int temp=number;
        while(number>0)
            {
                int digit=number%10;
                num=(num*10)+digit;
                number/=10;          
            }
        if(temp==num)
            {
                System.out.println("true"); 
            }else
               {
                  System.out.println("false");  
                }
        
    }
}