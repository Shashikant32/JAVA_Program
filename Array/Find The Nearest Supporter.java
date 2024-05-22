import java.util.*;

class Solution {
    public int[] prevSmall(int[] row) {
        int n = row.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); 
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && row[stack.peek()] >= row[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = row[stack.peek()];
            }
            stack.push(i);
        }
        
        return result;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution obj = new Solution();
        int[] res = obj.prevSmall(arr);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
        System.out.println();
        sc.close();
    }
}
