import java.io.*;
import java.util.*;

class Solution {
    static int minOperation(String s) {
        int countUpper = 0;
        int countLower = 0;
        
        // Traverse the string and count uppercase and lowercase characters
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                countUpper++;
            } else if (Character.isLowerCase(c)) {
                countLower++;
            }
        }
        
        // Calculate the minimum number of operations needed
        return Math.min(countUpper, countLower);
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(Solution.minOperation(s));
    }
}
