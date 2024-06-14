import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Accio ob = new Accio();
        int ans = ob.findElement(arr, N, target);

        System.out.println(ans);
    }
}

class Accio {

    private int findPeakElement(int[] arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearchIncreasing(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchDecreasing(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int findElement(int[] arr, int n, int target) {
        int peak = findPeakElement(arr, 0, n - 1);
        
        int result = binarySearchIncreasing(arr, 0, peak, target);
        if (result != -1) {
            return result;
        }
        
        return binarySearchDecreasing(arr, peak + 1, n - 1, target);
    }
}
