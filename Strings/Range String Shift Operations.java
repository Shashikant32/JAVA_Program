import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = sc.nextInt();
        int[][] shifts = new int[m][3];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                shifts[i][j] = sc.nextInt();
            }
        }
        
        Solution answer = new Solution();
        System.out.println(answer.shiftingLetters(s, shifts));
    }
}

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] charArray = s.toCharArray();
        int n = s.length();
        long[] totalShifts = new long[n];
        
        // Calculate total shifts to apply to each character
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            totalShifts[start] += direction == 1 ? 1 : -1;
            if (end + 1 < n) {
                totalShifts[end + 1] -= direction == 1 ? 1 : -1;
            }
        }
        
        // Apply the shifts to construct the final string
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += totalShifts[i];
            charArray[i] = shiftCharacter(charArray[i], cumulativeShift);
        }
        
        return new String(charArray);
    }
    
    private char shiftCharacter(char c, long shift) {
        // Calculate the final character after applying the given shift
        int mod = (int) (shift % 26);
        char shiftedChar = (char) ((c - 'a' + mod + 26) % 26 + 'a');
        return shiftedChar;
    }
}
