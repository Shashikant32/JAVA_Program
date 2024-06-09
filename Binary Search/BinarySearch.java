import java.util.*;

public class BinarySearch{
    public static int findIndex(int key, int[] arr, int n) { 
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == key) { 
                return mid;
            }
            if (arr[mid] > key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr, n)); 
        sc.close();
    }
}
