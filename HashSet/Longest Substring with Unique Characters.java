import java.util.*;

class Solution {
    public int longestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLen = 0;
        
        while (right < n) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(currentChar);
            
            maxLen = Math.max(maxLen, right - left + 1);
            
            right++;
        }
        
        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution ob = new Solution();
        int ans = ob.longestSubstring(s);
        System.out.println(ans);
    }
}
