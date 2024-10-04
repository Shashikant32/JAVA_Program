import java.io.*;
import java.util.*;

class Solution {
    public String allStar(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return s.charAt(0) + "*" + allStar(s.substring(1));
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution obj = new Solution();
        System.out.println(obj.allStar(s));
        sc.close();
    }
}
