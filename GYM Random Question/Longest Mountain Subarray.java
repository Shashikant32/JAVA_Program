import java.util.*;

class Solution {
    public int longestMountainSubarray(int[] arr) {
        int n = arr.length;
        int maxMountainLength = 0;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                int mountainLength = right - left + 1;

                maxMountainLength = Math.max(maxMountainLength, mountainLength);
            }
        }

        return maxMountainLength >= 3 ? maxMountainLength : 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
        int res = Obj.longestMountainSubarray(arr);
        System.out.println(res);
    }
}
