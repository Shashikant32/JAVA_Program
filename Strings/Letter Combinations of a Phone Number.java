import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        if(digits.isEmpty()){
            System.out.println("");
        }
        else{
            List<String> ans = Solution.letterCombinations(digits);
            Collections.sort(ans);
            for(int i=0;i<ans.size();i++){
                System.out.print("" + ans.get(i) + " ");
            }

        }
        
    }
}

class Solution {
    
    static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    static void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
