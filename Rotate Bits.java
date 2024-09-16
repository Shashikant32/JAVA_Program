import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        Solution ob = new Solution();
        ArrayList<Integer> ans = ob.rotate(n, k);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}

class Solution {
    public ArrayList<Integer> rotate(int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int numBits = 16;
        
        k = k % numBits;
        
        int leftRotated = ((n << k) | (n >> (numBits - k))) & 0xFFFF;
        
        int rightRotated = ((n >> k) | (n << (numBits - k))) & 0xFFFF;
        
        result.add(leftRotated);
        result.add(rightRotated);
        
        return result;
    }
}
