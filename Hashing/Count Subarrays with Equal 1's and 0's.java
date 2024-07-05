import java.util.*;

class Solution {
    static int countEqualSubarray01(int arr[], int n) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); 
        
        for (int i = 0; i < n; i++) {
            prefixSum += (arr[i] == 0) ? -1 : 1;
            
            if (prefixSumCount.containsKey(prefixSum)) {
                count += prefixSumCount.get(prefixSum);
            }
            
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.countEqualSubarray01(arr, N));

        sc.close();
    }
}
