import java.util.*;

class Solution {
    public void nonRepeatingCharacter(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("-1");
            return;
        }
        
        Map<Character, Integer> freqMap = new LinkedHashMap<>(); 
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        for (char ch : s.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                System.out.println(ch);
                return;
            }
        }
        System.out.println("-1");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution obj = new Solution();
        obj.nonRepeatingCharacter(s);
    }
}
