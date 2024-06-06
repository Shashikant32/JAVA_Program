import java.util.*;

public class Main {

    static int findMinDiff(int n, int m, ArrayList<Integer> chocolates) {
        Collections.sort(chocolates); 
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < n; i++) {
            int difference = chocolates.get(i + m - 1) - chocolates.get(i);
            if (difference < minDifference) {
                minDifference = difference;
            }
        }
        return minDifference;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.println(findMinDiff(n, m, arr));
        }
    }
}
