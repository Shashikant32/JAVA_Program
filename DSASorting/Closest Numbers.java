import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution ob = new Solution();
        ArrayList<Integer> ans = ob.mindif(a, n);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}

class Solution {
    public ArrayList<Integer> mindif(int[] a, int n) {
        Arrays.sort(a);
        
        int minDiff = Integer.MAX_VALUE;
        ArrayList<int[]> pairs = new ArrayList<>();
        
        for (int i = 1; i < n; i++) {
            int diff = a[i] - a[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                pairs.clear(); 
                pairs.add(new int[]{a[i - 1], a[i]}); 
            } else if (diff == minDiff) {
                pairs.add(new int[]{a[i - 1], a[i]}); 
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] pair : pairs) {
            result.add(pair[0]);
            result.add(pair[1]);
        }
        
        return result;
    }
}
