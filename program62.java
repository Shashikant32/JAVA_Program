import java.util.*;


public class Main {
    public static void main(String[] args) {
        //Plus Minus
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        printRatios(arr);
        sc.close();
    }

    public static void printRatios(int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveCount++;
            } else if (arr[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        
        double positiveRatio = (double) positiveCount / arr.length;
        double negativeRatio = (double) negativeCount / arr.length;
        double zeroRatio = (double) zeroCount / arr.length;
        
        System.out.printf("%.6f%n", positiveRatio);
        System.out.printf("%.6f%n", negativeRatio);
        System.out.printf("%.6f%n", zeroRatio);
    }
}