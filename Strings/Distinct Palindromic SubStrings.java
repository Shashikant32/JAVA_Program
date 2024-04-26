import java.util.*;

public class Main {
    static void palindromeSubStrs(String s) {
        Set<String> result = new TreeSet<>();
        int n = s.length();
        
        // Check all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    result.add(substring);
                }
            }
        }
        
        // Print the palindromic substrings
        for (String substring : result) {
            System.out.println(substring);
        }
    }

    static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        palindromeSubStrs(s);
    }
}
