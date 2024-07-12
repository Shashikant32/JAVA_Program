import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        int d[] = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(new Solution().tour(p, d));
    }
}

class Solution {
    int tour(int petrol[], int distance[]) {
        int n = petrol.length;
        int total_petrol = 0;
        int current_petrol = 0;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            total_petrol += petrol[i] - distance[i];
            current_petrol += petrol[i] - distance[i];

            // If current petrol becomes negative, reset starting index
            if (current_petrol < 0) {
                start_index = i + 1;
                current_petrol = 0;
            }
        }

        // Check if we have enough petrol to complete the circle
        if (total_petrol >= 0) {
            return start_index;
        } else {
            return -1;
        }
    }
}
