import java.util.*;

class Solution {
    public int candies(ArrayList<Integer> A, int n) {
        if (n == 0) return 0;
        
        int[] candies = new int[n];
        Arrays.fill(candies, 1);  // Step 1: Initialize each child with 1 candy
        
        // Step 2: Left to Right pass
        for (int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Step 3: Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Step 4: Calculate the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        sc.close();
        
        Solution ob = new Solution();
        System.out.println(ob.candies(arr, n));
    }
}
