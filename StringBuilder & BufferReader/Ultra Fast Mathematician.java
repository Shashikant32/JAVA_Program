import java.util.*;
  
public class Main{
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String A=scn.nextLine();
        String B=scn.nextLine();
        StringBuilder a= new StringBuilder(A);
        StringBuilder b= new StringBuilder(B);
        StringBuilder c=solve(a,b);
        System.out.println(c);
    }
    static StringBuilder solve(StringBuilder a, StringBuilder b)
    {
        StringBuilder c = new StringBuilder();
        for(int i=0; i< a.length(); i++)
            {
                if(a.charAt(i) != b.charAt(i))
                {
                    c.append("1");
                }else
                {
                    c.append("0");
                }
            }
        return c;
    }

    
}