import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int solve(int[] A, int B) {
        int left = 0;
        int right = Arrays.stream(A).max().getAsInt();
        int maxHeight = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long woodCut = 0;

            for (int height : A) {
                if (height > mid) {
                    woodCut += height - mid;
                }
            }

            if (woodCut >= B) {
                maxHeight = mid; // Found a valid height, try for higher
                left = mid + 1;
            } else {
                right = mid - 1; // Try lower heights
            }
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();

        System.out.println(solve(A, B));
    }
}
