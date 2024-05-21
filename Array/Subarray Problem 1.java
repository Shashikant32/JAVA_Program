import java.util.*;

public class Main {

    public static void solve(int[] arr, int n, int s) {
        int currentSum = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            while (currentSum > s) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == s && i - start + 1 == n) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = sc.nextInt();
        int s = sc.nextInt();
        solve(arr, n, s);
    }
}
