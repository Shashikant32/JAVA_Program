import java.util.*;

public class Main {
    
    static void shuffleString(int[] indices, String s) {
        char[] shuffledChars = new char[s.length()];

        // Place each character from the input string at the corresponding index in the shuffledChars array
        for (int i = 0; i < indices.length; i++) {
            shuffledChars[indices[i]] = s.charAt(i);
        }

        // Construct a new string from the shuffled character array
        StringBuilder sb = new StringBuilder();
        for (char ch : shuffledChars) {
            sb.append(ch);
        }

        // Print the shuffled string
        System.out.println(sb.toString());
    }    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String str = sc.next();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        shuffleString(arr, str);
        sc.close();
    }
}
