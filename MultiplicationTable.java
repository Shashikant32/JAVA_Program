import java.io.*;
import java.util.*;

class Solution {
    public static void solve(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        if (n >= 1 && n <= 100000) {
            Solution.solve(n);
        } else {
            System.out.println("Input must be between 1 and 100000.");
        }
        
        s.close(); 
    }
}
