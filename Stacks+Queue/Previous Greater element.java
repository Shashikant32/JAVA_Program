import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Solution {
    public long[] prevGreater(long[] arr, int n) {
        long[] result = new long[n];
        Stack<Long> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] inputLine = br.readLine().trim().split(" ");
        long[] arr = new long[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(inputLine[i]);
        }
        
        Solution obj = new Solution();
        long[] res = obj.prevGreater(arr, n);
        
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        
        br.close();
    }
}
