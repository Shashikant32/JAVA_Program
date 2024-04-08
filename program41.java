import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Buildings
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int maxHeight = 0;
        for (int height : arr) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        for (int row = maxHeight; row > 0; row--) {
            for (int col = 0; col < n; col++) {
                if (arr[col] >= row) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
