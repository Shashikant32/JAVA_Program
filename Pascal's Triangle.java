import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void solve(int numRows) {
        if (numRows <= 0) {
            return; // No output for zero rows
        }

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);

            if (i > 0) {
                ArrayList<Integer> prevRow = triangle.get(triangle.size() - 1);
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                row.add(1);
            }

            triangle.add(row);
        }

        for (ArrayList<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        solve(K);
        sc.close();
    }
}
