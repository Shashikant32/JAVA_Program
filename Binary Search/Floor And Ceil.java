import java.util.*;

public class Main {
    public static int[] floorAndCeil(int key, int[] arr) {
        int n = arr.length;
        int floor = -1;
        int ceil = -1;
        
        int left = 0;
        int right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == key) {
                return new int[]{key, key};
            } else if (arr[mid] < key) {
                floor = arr[mid];
                left = mid + 1;
            } else {
                ceil = arr[mid];
                right = mid - 1;
            }
        }
        
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        
        int[] result = floorAndCeil(key, arr);
        System.out.println(result[0] + " " + result[1]);
    }
}
