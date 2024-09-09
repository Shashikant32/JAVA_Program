import java.util.*;

class Solution {
    public void solve(Scanner sc) {
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        // Compute GCD
        int gcd = computeGCD(num1, num2);
        
        // Compute LCM
        int lcm = computeLCM(num1, num2, gcd);
        
        System.out.println(gcd);
        System.out.println(lcm);
    }

    //compute GCD using Euclidean algorithm
    private int computeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // compute LCM using the formula LCM(a, b) = abs(a*b) / GCD(a, b)
    private int computeLCM(int a, int b, int gcd) {
        return Math.abs(a * b) / gcd;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        solution.solve(sc);
        sc.close();
    }
}
