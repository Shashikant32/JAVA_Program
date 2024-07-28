import java.io.*;
import java.util.*;

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
        // Your code here
        int n = str.length();
        HashMap<Character,Integer> mp = new HashMap<>();
         int ans=0, i=0, j=0;
        while(j<n)
            {
                //check if freq of jth char is 0 or not
                // check if jth char existe is mp or not
                
                if(!mp.containsKey(str.charAt(j)))
                {
                    mp.put(str.charAt(j),1);
                    ans=Math.max(ans,j-i+1);
                    j++;
                }else
                {
                    // remove ith char until freq of char at j becomes 0
                    while(str.charAt(i) != str.charAt(j))
                        {
                            mp.remove(str.charAt(i));
                            i++;
                        }
                     mp.remove(str.charAt(i));
                    i++;
                    
                }
            }
        return ans;
        
    }
}

public class Main {
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

