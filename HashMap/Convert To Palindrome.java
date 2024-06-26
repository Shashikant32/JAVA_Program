import java.util.*;

class Solution {
    public int solve(String A) {
        int left = 0, right = A.length() - 1;
        
        while (left < right) {
            if (A.charAt(left) != A.charAt(right)) {
                if (isPalindrome(A, left + 1, right)) {
                    return 1;
                }
                if (isPalindrome(A, left, right - 1)) {
                    return 1;
                }
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
    
    private boolean isPalindrome(String A, int start, int end) {
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        
        Solution obj = new Solution();
        int ans = obj.solve(A);
        System.out.println(ans);
        
        sc.close();
    }
}
