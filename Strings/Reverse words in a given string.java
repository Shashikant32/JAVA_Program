import java.io.*;

class Solution {
    static String solve(String s) {
        String[] words = s.split("\\.");
        
        StringBuilder result = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(".");
            }
        }
        
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
 
        String out_ = Solution.solve(s);
        System.out.println(out_);
 
        br.close();
    }
}
