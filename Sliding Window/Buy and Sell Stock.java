import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int ans = Solution.bestTimeToBuyAndSell(n, a);
        System.out.println(ans);
    }
}

class Solution {
    static int bestTimeToBuyAndSell(int n, int[] prices) {
        if (n == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
