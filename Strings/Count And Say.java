import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());

        Solution ob = new Solution();
        System.out.println(ob.countAndSay(n));
    }
}

class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        String result = "1"; // first term
        
        for (int i = 2; i <= n; i++) {
            result = generateNext(result); // Generate the next term
        }
        
        return result;
    }
    
    private String generateNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char current = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == current) {
                count++;
            } else {
                sb.append(count);
                sb.append(current);
                current = s.charAt(i);
                count = 1;
            }
        }
        
        // Append the last count and digit
        sb.append(count);
        sb.append(current);
        
        return sb.toString();
    }
}
