import java.util.HashSet;
import java.util.Set;
import java.util.*;
class Solution {
    public static String removeChars(String s1, String s2) {
        Set<Character> charsToRemove = new HashSet<>();
        for (char c : s2.toCharArray()) {
            charsToRemove.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : s1.toCharArray()) {
            if (!charsToRemove.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        Solution obj = new Solution();
        System.out.println(obj.removeChars(s1, s2));
    }
}
