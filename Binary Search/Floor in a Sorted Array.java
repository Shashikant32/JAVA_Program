import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int floorIndex = findFloorIndex(arr, x);

        System.out.println(floorIndex);
    }

    public static int findFloorIndex(int[] arr, int x) {
        int e = 0;
        int s = arr.length - 1;
        int floorIndex = -1;

        while (e <= s) {
            int mid = e + (s - e) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                floorIndex = mid; 
                e = mid + 1;
            } else {
                s = mid - 1;
            }
        }

        return floorIndex;
    }
}
