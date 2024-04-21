import java.util.*;

public class Main {
    public static char LowerUpper(char ch) {
        //Write your code here
        
        if(ch>='a' && ch<='z')
        {
            return 'L';
        }
        
             return 'U';
       
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        System.out.println(LowerUpper(ch));
    }
}