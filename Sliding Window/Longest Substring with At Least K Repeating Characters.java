import java.util.*;

class Solution {
    public int longestSubstring(String s, int k) {
        // write code here
        if(k>s.length()) return 0;
        int n =s.length();
        int ans=0;
        for(int uc = 1; uc<=26; uc++)
            {
                int i=0,j=0;
                HashMap<Character,Integer> mp = new HashMap<>();
                while(j<n)
                    {
                        mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)+1);
                        if(mp.size()> uc)
                        {
                            //shrink from left
                            //shrink unitl mp size becomes equals to uc
                            while(mp.size()>uc)
                                {
                                    if(mp.get(s.charAt(i))==1)mp.remove(s.charAt(i));
                                    else mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                                    i++;
                                }
                        }
                        // if(mp.size()==uc)
                        // {
                            //check is this cand string
                            boolean flag = true;
                            for(char it : mp.keySet())
                                {
                                    if(mp.get(it)<k)
                                    {
                                        flag = false;
                                    }
                                }
                            if(flag == true) ans = Math.max(ans,j-i+1);
                        // }
                        j++;
                    }
            }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
