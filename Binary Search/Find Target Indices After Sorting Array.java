import java.util.*;
import java.io.*;

class Solution {
    public static int[] binary(int a[], int n, int k) {
        Arrays.sort(a);
        
        List<Integer> targetIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                targetIndices.add(i);
            }
        }

        if (targetIndices.isEmpty()) {
            return new int[]{-1};
        }

        int[] result = new int[targetIndices.size()];
        for (int i = 0; i < targetIndices.size(); i++) {
            result[i] = targetIndices.get(i);
        }
        return result;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int arr[] = Solution.binary(a, n, k);
        int le = arr.length;
        for (int i = 0; i < le; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
