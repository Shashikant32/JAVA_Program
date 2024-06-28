import java.util.Scanner;

class Solution {
    public static String removeDuplicates(String s)
    {
        int n = s.length();
        if(n<=1)
        {
            return s;
        }
       boolean hasDuplicates = false;
        String ans = "";

        if(s.charAt(0) != s.charAt(1))
        {
            ans += s.charAt(0);
        }else
        {
            hasDuplicates = true;
        }
        for(int i=1; i<n-1; i++)
            {
                if(s.charAt(i) != s.charAt(i-1) && s.charAt(i) != s.charAt(i+1))
                {
                    ans +=s.charAt(i);
                }else
                {
                    hasDuplicates = true;
                }
            }
        if(s.charAt(n-1) != s.charAt(n-2))
                    {
                        ans += s.charAt(n-1);
                    }else
                    {
                        hasDuplicates = true;
                    }
                if(hasDuplicates == false)
                {
                    return ans;
                }
        return removeDuplicates(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution Obj = new Solution();
        System.out.println(Obj.removeDuplicates(str));
    }
}
