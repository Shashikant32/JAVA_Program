import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int position[] = new int[n];
        for(int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        int ans = obj.magneticForce(position, n, m);
        System.out.println(ans);
    }
}

class Solution {
    int magneticForce(int position[], int n, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[n - 1] - position[0]; 
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceBalls(position, n, m, mid)) {
                result = mid; 
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return result;
    }

    private boolean canPlaceBalls(int[] position, int n, int m, int minDist) {
        int count = 1;
        int lastPos = position[0]; 

        for (int i = 1; i < n; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if (count == m) {
                    return true;
                }
            }
        }

        return false;
    }
}
