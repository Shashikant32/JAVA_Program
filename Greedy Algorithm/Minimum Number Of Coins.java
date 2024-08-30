import java.util.Scanner;

class Solution {
    public void coinChange(int num) {
        int[] denominations = {500, 100, 50, 20, 10, 5, 2, 1};
        int[] count = new int[denominations.length]; // Array to store count of each denomination
        
        for (int i = 0; i < denominations.length; i++) {
            count[i] = num / denominations[i];
            num = num % denominations[i];
        }
        
        System.out.println("Number of 500 Rupees Notes: " + count[0]);
        System.out.println("Number of 100 Rupees Notes: " + count[1]);
        System.out.println("Number of 50 Rupees Notes: " + count[2]);
        System.out.println("Number of 20 Rupees Notes: " + count[3]);
        System.out.println("Number of 10 Rupees Notes: " + count[4]);
        System.out.println("Number of 5 Rupees Notes: " + count[5]);
        System.out.println("Number of 2 Rupees Notes: " + count[6]);
        System.out.println("Number of 1 Rupees Notes: " + count[7]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Solution obj = new Solution();
        obj.coinChange(n);
        input.close(); // Close the scanner to avoid resource leaks
    }
}
