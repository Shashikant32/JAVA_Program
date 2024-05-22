import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (k < 0) {
            k = n + k;
        }
        k = k % n;
        
        int[] temp = new int[n];
        
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        rotateArray(arr, k);
        
        for(int num : arr){
            System.out.print(num + " "); 
        }
        
        scanner.close();
    }
}
