import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        //Pascal's Triangle
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

	public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) {
      ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    ArrayList<Integer> prevRow = triangle.get(i - 1);
                    int num = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(num);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }
}
