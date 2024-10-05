import java.util.*;
import java.io.*;

class Solution {
    public static int series(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        
        int[] T = new int[n + 1]; // n + 1 because we are using 1-based indexing
        T[1] = 0; // T1
        T[2] = 1; // T2
        
        for (int i = 3; i <= n; i++) {
            T[i] = (T[i - 2] * T[i - 2]) - T[i - 1];
        }
        
        return T[n];
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.print(Solution.series(n));
        }
    }
}
