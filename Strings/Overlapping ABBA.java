import java.util.*;

class Solution {   
    static boolean findOverlap(String s) {
        int len = s.length();
        
        boolean foundAB = false;
        boolean foundBA = false;
        
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == 'A' && s.charAt(i + 1) == 'B') {
                if (foundBA) {
                    return true; // We found "AB" after "BA"
                }
                foundAB = true; // We found "AB"
                i++;
            }
            else if (s.charAt(i) == 'B' && s.charAt(i + 1) == 'A') {
                if (foundAB) {
                    return true; // We found "BA" after "AB"
                }
                foundBA = true; // We found "BA"
                i++; 
            }
        }
        
        return false; 
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean ans = Solution.findOverlap(s);
        if(ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
