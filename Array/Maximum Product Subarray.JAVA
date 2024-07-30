import java.io.*;
import java.util.*;

class Solution {

    long maxProduct(int[] arr, int n) {
        if (n == 0) return 0;

        long maxEndingHere = arr[0];
        long minEndingHere = arr[0];
        long maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            int current = arr[i];

            long tempMax = Math.max(current, Math.max(maxEndingHere * current, minEndingHere * current));
            minEndingHere = Math.min(current, Math.min(maxEndingHere * current, minEndingHere * current));
            maxEndingHere = tempMax;

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
