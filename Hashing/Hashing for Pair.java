import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int targetSum = Integer.parseInt(firstLine[1]);
        
        String[] arrInput = br.readLine().split(" ");
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }
        
        Set<Integer> seen = new HashSet<>();
        
        for (int number : arr) {
            int complement = targetSum - number;
            if (seen.contains(complement)) {
                System.out.println("1");
                return;
            }
            seen.add(number);
        }
        
        System.out.println("0");
    }
}
