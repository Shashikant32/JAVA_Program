import java.io.*;
import java.util.*;

class Solution {
    public int countPairs(String s) {
        return countPairsHelper(s, 0);
    }

    private int countPairsHelper(String s, int index) {
        if (index >= s.length() - 2) {
            return 0; // Base case: not enough characters left for a pair
        }

        int count = 0;
        if (s.charAt(index) == s.charAt(index + 2)) {
            count = 1; // Found a pair
        }

        return count + countPairsHelper(s, index + 1);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution obj = new Solution();
        System.out.println(obj.countPairs(s));
        sc.close();
    }
}
