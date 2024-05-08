import java.util.*;
public class Main {
    public static void printEncodings(String str) {
        helper(str,0,"");
		
    }
    static void helper(String str, int i , String curr)
    {
        if(i==str.length())
        {
            System.out.println(curr);
            return;
        }
        //oneDigit
        int oneDigit = str.charAt(i)-'0';
        if(oneDigit==0)
        {
            return;
        }
        if(oneDigit>0)
        {
            helper(str,i+1,curr+(char)('a'+ oneDigit-1));
        }
        //towDigit
        if(i==str.length()-1)
        {
            return;
        }
        int towDigit=Integer.parseInt(str.substring(i,i+2));
        if(towDigit<=26)
        {
            helper(str,i+2,curr+(char)('a'+towDigit-1));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}