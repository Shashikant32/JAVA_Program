import java.util.*;

class Accio {
    static int MinimumRemovals(int n, int k, int[] arr) {
        Arrays.sort(arr);

        int left = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            while (arr[right] - arr[left] > k) {
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return n - maxLen;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int ans = obj.MinimumRemovals(n, k, arr);
        System.out.println(ans);
    }
}
