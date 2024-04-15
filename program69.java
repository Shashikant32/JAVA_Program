import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Contains Duplicate
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean containsDuplicates = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    containsDuplicates = true;
                    break;
                }
            }
            if (containsDuplicates) {
                break;
            }
        }

        System.out.println(containsDuplicates);
    }
}
