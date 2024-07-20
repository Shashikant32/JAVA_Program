import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable { 
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int q = sc.nextInt(); 
        int[] arr = new int[n]; 
        for (int i = 0; i < n; i++) { 
            arr[i] = sc.nextInt();
        } 
    
        int[][] queries = new int[q][2]; 
        for (int i = 0; i < q; i++) { 
            queries[i][0] = sc.nextInt(); 
            queries[i][1] = sc.nextInt(); 
        } 
    
        Solution obj = new Solution();
        int[] result = obj.xorQueries(arr, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        int[] prefixXOR = new int[n];
        
        // Build the prefixXOR array
        prefixXOR[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        
        // Array to store results for each query
        int[] result = new int[q.length];
        
        // Process each query
        for (int i = 0; i < q.length; i++) {
            int left = q[i][0];
            int right = q[i][1];
            
            if (left == 0) {
                result[i] = prefixXOR[right];
            } else {
                result[i] = prefixXOR[right] ^ prefixXOR[left - 1];
            }
        }
        
        return result;
    }
}
