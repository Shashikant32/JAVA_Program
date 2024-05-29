import java.io.*;
import java.util.*;

class Solution{
    public int minCandies(int a[]) {
        int n = a.length;
        int[] candies = new int[n];
        // Initialize all children with 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        // Calculate the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.minCandies(a));
    }
}
