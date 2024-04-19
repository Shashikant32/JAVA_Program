import java.io.*;
import java.util.*;

public class Main {
	public static int triplets(ArrayList<Integer> arr, int X) {
	    // Triplet Sum to X
        int count = 0;
        int n = arr.size();

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr.get(i) + arr.get(left) + arr.get(right);

                if (sum == X) {
                    count++;
                    // Skip duplicate elements from left
                    while (left < right && arr.get(left) == arr.get(left + 1)) {
                        left++;
                    }
                    // Skip duplicate elements from right
                    while (left < right && arr.get(right) == arr.get(right - 1)) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < X) {
                    left++;
                } else {
                    right--;
                }
            }

            // Skip duplicate elements for i
            while (i < n - 2 && arr.get(i) == arr.get(i + 1)) {
                i++;
            }
        }

        return count;
	  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    while (t > 0) {
      int n, X;
      n = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<Integer>(n);
      for (int i = 0; i < n; i++) arr.add(sc.nextInt());
      X = sc.nextInt();
      int result = triplets(arr, X);
      System.out.println(result);
      t--;
    }
    sc.close();
  }

  
}