import java.util.*;

public class Main {

  static int goodStrings(String s, String[] A, int n) {
       int goodCount = 0;
        // Create a boolean array to indicate the presence of characters in set S
        boolean[] charSet = new boolean[26];
        for (char c : s.toCharArray()) {
            charSet[c - 'a'] = true; // Mark the character as present
        }
        // Iterate through each string in array A
        for (String str : A) {
            boolean isGood = true;

            // Check if all characters of the string are present in the set
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!charSet[c - 'a']) { // If character is not present, set isGood to false and break
                    isGood = false;
                    break;
                }
            }

            // If the string is good, increment the count
            if (isGood) {
                goodCount++;
            }
        }

        return goodCount;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      int n = sc.nextInt();
      String[] A = new String[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.next();
      }

      System.out.println(goodStrings(s, A, n));
    }
  }
}