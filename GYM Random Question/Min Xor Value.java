import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(minXorValue(A));
    }

    public static int minXorValue(int[] A) {
        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            int xorValue = A[i] ^ A[i + 1];
            if (xorValue < minXor) {
                minXor = xorValue;
            }
        }

        return minXor;
    }
}
