import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Array Operations.
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = calculateSum(arr);
        int average = calculateAverage(arr);
        int max = findMax(arr);

        System.out.println(sum + " " + average + " " + max);
    }
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    public static int calculateAverage(int[] arr) {
        int sum = calculateSum(arr);
        return sum / arr.length;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
