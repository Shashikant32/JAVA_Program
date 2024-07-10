import java.util.*;

class Solution {
    public int reverseInteger(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long reversed = 0; 

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        reversed *= sign; 

        
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversed;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.reverseInteger(x));
        sc.close();
    }
}
