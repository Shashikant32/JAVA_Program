import java.util.*;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int firstIndex(int[] arr, int n, int key) {
        int s = 0;
        int e = n - 1;
        int firstIndex = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == key) {
                firstIndex = mid;
                e = mid - 1; 
            } else if (arr[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return firstIndex;
    }
    
    public static int lastIndex(int[] arr, int n, int key) {
        int s = 0;
        int e = n - 1;
        int lastIndex = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == key) {
                lastIndex = mid;
                s = mid + 1;
            } else if (arr[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return lastIndex;
    }

    public static void findPosition(int[] a, int n, int k) {
        int first = firstIndex(a, n, k);
        int last = lastIndex(a, n, k);
        if (first != -1 && last != -1) {
            System.out.println(first + " " + last);
        } else {
            System.out.println(-1 + " " + -1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        findPosition(array, n, k);
        sc.close();
    }
}
