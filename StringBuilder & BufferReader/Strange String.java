import java.io.*;
import java.util.*;

public class Main {
    static String strangeString(int n) {
        StringBuilder ans = new StringBuilder();
        char c ='a';// int a=97;
        for(int i=0; i<n; i++)
            {
                // a= (char)((a+1)%97)+'a';
               if(i%2==0)
               {
                   ans.insert(0,c);//ans.insert(0,(char)a);
               }else
               {
                   ans.append(c);
               }
                c=(char)(c+1); // c++
                    if(c>'z')
                {
                    c='a';
                }
            }
        return ans.toString();
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0){
            int n = input.nextInt();
            System.out.println(strangeString(n));
        }
    }
}