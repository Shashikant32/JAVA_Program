import java.util.*;

class Solution {
    static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        int[] count = new int[26];
        
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution obj = new Solution();
        
        if (obj.areAnagram(str1, str2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        sc.close();
    }
}
