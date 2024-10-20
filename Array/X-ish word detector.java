import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine().trim();
        String xString = scanner.nextLine().trim();
        
        boolean isXish = isXishWord(word, xString);
        
        System.out.println(isXish);
    }
    
    public static boolean isXishWord(String word, String xString) {
        Set<Character> xSet = new HashSet<>();
        for (char c : xString.toCharArray()) {
            xSet.add(c);
        }
        
        for (char c : xSet) {
            if (word.indexOf(c) == -1) {
                return false; // If any character is missing, return false
            }
        }
        
        return true; // All characters are present
    }
}
