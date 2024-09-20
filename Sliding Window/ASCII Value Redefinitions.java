import java.util.*;

class Solution {
    public static String maxSum(String w, char[] x, int[] b, int n) {
        Map<Character, Integer> asciiMap = new HashMap<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            asciiMap.put(c, (int) c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            asciiMap.put(c, (int) c);
        }
        
        for (int i = 0; i < n; i++) {
            asciiMap.put(x[i], b[i]);
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < w.length(); i++) {
            currentSum += asciiMap.get(w.charAt(i));

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = start;
                maxEnd = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1; // Start new substring from next character
            }
        }

        return w.substring(maxStart, maxEnd + 1);
    }
}

class Main {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        char[] x = new char[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.next().charAt(0);
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // Function call
        System.out.println(Solution.maxSum(s, x, b, n));
    }
}
