import java.util.*;

class Solution {
    public ArrayList<Integer> MajorityElements(int[] arr) {
        // Define constants for majority threshold
        int n = arr.length;
        int threshold = n / 3;

        // Step 1: Find potential majority elements
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;

        for (int num : arr) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Solution obj = new Solution();
        ArrayList<Integer> ans = obj.MajorityElements(arr);
        Collections.sort(ans);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
