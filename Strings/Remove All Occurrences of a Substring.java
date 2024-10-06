import java.util.*;

class Solution {
    static String minString(String str, String K) {
        StringBuilder sb = new StringBuilder(str);
        int index;

        while ((index = sb.indexOf(K)) != -1) {
            sb.delete(index, index + K.length());
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String ans = Solution.minString(s1, s2);
        System.out.println(ans.length() > 0 ? ans : "-1");
    }
}
