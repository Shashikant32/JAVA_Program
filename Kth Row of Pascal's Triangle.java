import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        Solution obj = new Solution();
        obj.solve(k);
        System.out.println();
    }
}

class Solution {
    public static void solve(int k) {
        List<Integer> row = new ArrayList<>();
        
        row.add(1);
        
        for (int j = 1; j <= k; j++) {
            int nextElement = row.get(j - 1) * (k - (j - 1)) / j;
            row.add(nextElement);
        }
        
        for (int num : row) {
            System.out.print(num + " ");
        }
    }
}
