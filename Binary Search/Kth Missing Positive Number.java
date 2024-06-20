import java.util.Scanner;

class Solution {
    public static int findKthPositive(int[] A, int k) {
        int expected = 1;
        int idx = 0;
        int missingCount = 0;
        
        while (missingCount < k) {
            if (idx < A.length && A[idx] == expected) {
                idx++;
            } else {
                missingCount++;
            }
            expected++;
        }
        
        return expected + (k - missingCount) - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(Solution.findKthPositive(array, k));
        scanner.close();
    }
}
