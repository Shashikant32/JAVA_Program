import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int distance = Integer.MAX_VALUE;

        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0 && arr[i] > 0) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                    distance = Math.min(distance, Math.abs(firstIndex - secondIndex));
                    firstIndex = secondIndex;
                }
            }
        }

        if (distance == Integer.MAX_VALUE || distance == 0) {
            System.out.println("-1");
        } else {
            System.out.println(distance);
        }

        scanner.close();
    }
}
