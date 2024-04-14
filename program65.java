import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Right Rotate
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] rotatedArray = rightRotate(arr, k);

        for (int i = 0; i < n; i++) {
            System.out.print(rotatedArray[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
    private static int[] rightRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; 

        int[] rotatedArray = new int[n];

        for (int i = 0; i < n; i++) {
            rotatedArray[(i + k) % n] = arr[i];
        }

        return rotatedArray;
    }
}
