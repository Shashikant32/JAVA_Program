import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum = (sum + num) % p;
        }

        int target = sum % p;
        
        if (target == 0) {
            return 0; // The sum is already divisible by p
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Initialize with remainder 0 at index -1
        
        int curr = 0;
        int result = n; // Start with an impossible result length
        
        for (int j = 0; j < n; j++) {
            curr = (curr + nums[j]) % p;

            int remain = (curr - target + p) % p;
            
            if (map.containsKey(remain)) {
                result = Math.min(result, j - map.get(remain)); // Update the result
            }
            
            map.put(curr, j);
        }

        return result == n ? -1 : result; // If no valid subarray found, return -1
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read the size of the array
        int p = sc.nextInt(); // Read the divisor p
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt(); // Read the elements of the array
        }
        Solution obj = new Solution();
        // Correct method call with two arguments
        System.out.println(obj.minSubarray(a, p)); // Only pass array and p
        sc.close();
    }
}
