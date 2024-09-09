import java.util.*;

class Solution {
    static void sumEvenOdd() {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int evenSum = 0;
        int oddSum = 0;
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        
        System.out.println("Even " + evenSum + " Odd " + oddSum);
        
        sc.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution.sumEvenOdd();
    }
}
