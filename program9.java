import java.util.*;
  
class Main {
	public static void main(String args[]) {
        // Odd Numbers
		  Scanner scr= new Scanner(System.in);
        int count=0;
        while(true)
        {
            int n=scr.nextInt();
            count=count+1;
            if(n%2==1)
            {
                break;
            }
            
        }
        System.out.println(count);
	}
}