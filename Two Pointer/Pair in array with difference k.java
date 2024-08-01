import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.findPairs(a, n, k));
        sc.close();
    }
}

class Solution {
    public int findPairs(int[] nums, int n, int k) {
        if (k < 0) return 0; // k-diff pairs are not possible with negative k

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
