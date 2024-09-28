import java.io.*;
import java.util.*;

class Solution {
    static int specialSum(ArrayList<Integer> arr, int n) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        while (sum >= 10) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10; 
                sum /= 10; 
            }
            sum = tempSum; 
        }

        return sum; 
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int ans = Solution.specialSum(arr, n);
        System.out.println(ans);
    }
}
