import java.util.Arrays;
import java.util.Scanner;

public class Main {
   
    static int findIndex(int[] arr, int n, int k) {
           for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
         for (int i = 0; i < n; i++) {
           
            if (arr[i] == k) {
                return i ;
            }
        }
        
        return -1;
    }
           

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Input size of array
        int[] arr = new int[n]; // Declare array of size n

        // Input elements into the array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt(); // Input value of k

        // Call the function findIndex and store the result in index
        int index = findIndex(arr, n, k);

        // Output the result
        System.out.println(index);

        scanner.close(); // Close the scanner
    }
}

