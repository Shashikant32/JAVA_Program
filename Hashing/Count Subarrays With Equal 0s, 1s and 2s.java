import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countEqualSubarray012(arr, N));
        sc.close();
    }

    public static int countEqualSubarray012(int[] arr, int n) {
        // To store the frequency of (diff01, diff02)
        Map<String, Integer> map = new HashMap<>();
        // Initial condition: (0, 0) with frequency 1
        map.put("0,0", 1);

        int count0 = 0, count1 = 0, count2 = 0;
        int result = 0;

        for (int num : arr) {
            // Update counts
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }

            // Calculate the differences
            int diff01 = count1 - count0;
            int diff02 = count2 - count0;

            // Create the key for the current (diff01, diff02)
            String key = diff01 + "," + diff02;

            // If the key exists in the map, it means there are some subarrays
            // with equal number of 0s, 1s, and 2s
            if (map.containsKey(key)) {
                result += map.get(key);
            }

            // Update the map with the current key
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return result;
    }
}
