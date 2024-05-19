import java.util.*;

class Solution {
    public static int minCharsforPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();
        String concat = str + "#" + rev;
        
        int N = concat.length();
        int[] lps = computeLPS(concat);
        
        return str.length() - lps[N - 1];
    }
    
    public static int[] computeLPS(String str) {
        int N = str.length();
        int[] lps = new int[N];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        
        while (i < N) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume newline
        
        while (t-- > 0) {
            String str = sc.nextLine().trim();
            System.out.println(Solution.minCharsforPalindrome(str));
        }
        
        sc.close();
    }
}
