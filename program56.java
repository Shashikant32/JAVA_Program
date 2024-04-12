import java.io.*;
import java.util.*;

public class Main {
      // Pairs Given an array of N integers
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); 
        int k = scanner.nextInt(); 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Arrays.sort(arr);
        
        int pairsCount = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && arr[j] - arr[i] <= k) {
                if (arr[j] - arr[i] == k) {
                    pairsCount++;
                }
                j++;
            }
        }
        System.out.println(pairsCount);
        
        scanner.close();
    }
}