import java.util.Scanner;

class Solution {
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1; 
    }

    private int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        } else {
            return (josephus(n - 1, k) + k) % n;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution obj = new Solution();
        int ans = obj.findTheWinner(n, k);
        System.out.println(ans);
        sc.close();
    }
}
