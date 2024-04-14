import java.util.*;

public class Main {
    public static int[] minMaxSumProduct(int[] arr) {
        //Sum and Product of maximum and minimum
        int min = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        int sum = min + max;
        int product = min * max;
        
        return new int[]{sum, product};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] result = minMaxSumProduct(arr);
            System.out.println(result[0] + " " + result[1]);
        }
        
        scanner.close();
    }
}
