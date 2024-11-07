import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = Solution.isArmstrongOrNot(N);
        System.out.println(ans);
    }
}

class Solution {
    static int isArmstrongOrNot(int N) {
        int originalNumber = N;
        int numDigits = 0;
        while (N > 0) {
            N /= 10;
            numDigits++;
        }

        N = originalNumber; 
        int sum = 0;
        while (N > 0) {
            int digit = N % 10;
            sum += Math.pow(digit, numDigits);
            N /= 10;
        }

        if (sum == originalNumber) {
            return 1; // Armstrong number
        } else {
            return 0; // Not an Armstrong number
        }
    }
}
