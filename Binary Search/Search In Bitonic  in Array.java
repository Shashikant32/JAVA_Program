import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        Accio ob = new Accio();
        int ans = ob.findElement(arr, N, target);

        System.out.println(ans);
    }
}

class Accio {

    static int findElement(int arr[], int n, int target) {
        int peakIndex = findPeakIndex(arr, n);

        int leftResult = binarySearchAscending(arr, 0, peakIndex, target);
        if (leftResult != -1) {
            return leftResult;
        }

        int rightResult = binarySearchDescending(arr, peakIndex + 1, n - 1, target);
        return rightResult;
    }

    static int findPeakIndex(int[] arr, int n) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int binarySearchAscending(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    static int binarySearchDescending(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
