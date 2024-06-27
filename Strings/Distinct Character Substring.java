import java.util.*;

public class Main {
    public static long DistinctCharacterSubstring(String s){
        int n = s.length();
        int[] charCount = new int[128]; 
        int left = 0, right = 0;
        long count = 0;
        
        while (right < n) {
            char currentChar = s.charAt(right);
            
            while (charCount[currentChar] > 0) {
                charCount[s.charAt(left)]--;
                left++;
            }
            
            charCount[currentChar]++;
            
            count += (right - left + 1);
            
            right++;
        }
        
        return count;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
