import java.io.*;
import java.util.*;

public class Main {
	static int isPalindrome(String str)
      {
           str = str.toLowerCase();
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetter(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetter(str.charAt(right))) {
                right--;
            }
            
            if (str.charAt(left) != str.charAt(right)) {
                return 0;
            }
            
            left++;
            right--;
        }
        
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        int result = isPalindrome(str);
        System.out.println(result);        
    }
}