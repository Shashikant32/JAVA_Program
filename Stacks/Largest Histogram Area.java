import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(inputLine[i]);
        }
        
        Solution obj = new Solution();
        System.out.println(obj.maximumArea(arr, n));
    }
}

class Solution {
    public long maximumArea(long hist[], long n) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int tp; 
        
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                tp = stack.pop();
                long area = hist[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while (!stack.isEmpty()) {
            tp = stack.pop();
            long area = hist[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
