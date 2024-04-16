import java.util.Scanner;
import java.util.Vector;

class Solution {
    public Vector<Integer> spiralMatrix2(Vector<Vector<Integer>> arr, int n, int m) {
        //Spiral Matrix 2
   
        Vector<Integer> result = new Vector<>();
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            // Traverse left column
            for (int i = top; i <= bottom; i++) {
                result.add(arr.get(i).get(left));
            }
            left++;

            // Traverse bottom row
            for (int i = left; i <= right; i++) {
                 result.add(arr.get(bottom).get(i));
            }
            bottom--;

            // Traverse right column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(arr.get(i).get(right));
                }
                right--;
            }

            // Traverse top row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(arr.get(top).get(i));
                }
                top++;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Vector<Vector<Integer>> matrix = new Vector<>(n);

            for (int i = 0; i < n; i++) {
                Vector<Integer> row = new Vector<>(m);
                for (int j = 0; j < m; j++) {
                    row.add(sc.nextInt());
                }
                matrix.add(row);
            }

            Solution ob = new Solution();
            Vector<Integer> result = ob.spiralMatrix2(matrix, n, m);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }
}