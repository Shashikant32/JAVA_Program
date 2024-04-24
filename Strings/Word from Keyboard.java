import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<String> getStrings(ArrayList<String> arr)
    {  
        ArrayList<String> result = new ArrayList<>();

        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        for (String word : arr) {
            if (isWordFromOneRow(word.toLowerCase(), rows)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    public static boolean isWordFromOneRow(String word, String[] rows) {
        for (String row : rows) {
            boolean fromOneRow = true;
            for (char c : word.toCharArray()) {
                if (row.indexOf(c) == -1) {
                    fromOneRow = false;
                    break;
                }
            }
            if (fromOneRow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            arr.add(s);
        }

        ArrayList<String> result = getStrings(arr);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
