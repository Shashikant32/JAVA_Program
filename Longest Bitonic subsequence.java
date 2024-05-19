import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.bitonicSequence(n, array));
    } 
} 

class Solution 
{
    static int bitonicSequence(int n, int arr[])
    {
        if (n == 0) return 0;

        int[] lis = new int[n];
        int[] lds = new int[n];

        // Initialize LIS values for all indexes
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        // Compute LIS values from left to right
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Initialize LDS values for all indexes
        for (int i = 0; i < n; i++) {
            lds[i] = 1;
        }

        // Compute LDS values from right to left
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        // Find the maximum value of lis[i] + lds[i] - 1
        int max = lis[0] + lds[0] - 1;
        for (int i = 1; i < n; i++) {
            if (lis[i] + lds[i] - 1 > max) {
                max = lis[i] + lds[i] - 1;
            }
        }

        return max;
    }
}
