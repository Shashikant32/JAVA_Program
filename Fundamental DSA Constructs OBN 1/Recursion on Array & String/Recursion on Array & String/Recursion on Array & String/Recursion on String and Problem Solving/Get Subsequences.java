import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> generateSubsequences(String str)
    {
        ArrayList<String>ans = new ArrayList<>();
        helper(str,0,ans,""); 
        Collections.sort(ans);
        return ans;
    }
     static void helper(String str, int i, ArrayList<String>ans,String curr)
    {
        if(i==str.length())
        {
            if(curr!= "")
            {
             ans.add(curr);
             
            }
            return;
           
        }
        // optinon one --> jayega
        helper(str,i+1,ans,curr+str.charAt(i));
        //option two --> nahi jayega
        helper(str,i+1,ans,curr);
    }

    
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.nextLine();
        ArrayList<String> res = generateSubsequences(s);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}