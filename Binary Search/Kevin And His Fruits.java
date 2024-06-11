import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int ans = Solution.getMaxMarker(arr, n, m);
        System.out.println(ans);
    }
}

class Solution {
    static int getMaxMarker(ArrayList<Integer> arr, int n, int m) {
        int left = 0;
        int right = Collections.max(arr); 
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAtLeastM(arr, n, m, mid)) {
                result = mid; 
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean canEatAtLeastM(ArrayList<Integer> arr, int n, int m, int marker) {
        int totalFruits = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > marker) {
                totalFruits += (arr.get(i) - marker);
            }
            if (totalFruits >= m) {
                return true;
            }
        }
        return totalFruits >= m;
    }
}
