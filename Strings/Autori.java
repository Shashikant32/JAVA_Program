import java.io.*;
import java.util.*;

public class Autori {
	static String autori(String str){
        String ans="";
        for(int i=0; i<str.length(); i++)
            {
                char c=str.charAt(i);
                if(c>='A' && c<='Z')
                {
                    ans=ans+c;
                }
            }
        return ans;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String result = autori(str);
        System.out.print(result);        
        System.out.println('\n');
    }
}