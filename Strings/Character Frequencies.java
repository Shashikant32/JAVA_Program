import java.io.*;
import java.util.*;

class Solution {
    public void characterFrequencies(String s) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        
        System.out.println(frequencies.size());
        
        for (int freq : frequencies) {
            System.out.print(freq + " ");
        }
        System.out.println(); 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution obj = new Solution();
        obj.characterFrequencies(s);
    }
}
