import java.util.*;

class Solution {
    public void mostFrequent(String[] arr, int n) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        Map<String, Integer> lastOccurrenceIndex = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            lastOccurrenceIndex.put(word, i);
        }
        
        String mostFrequentWord = "";
        int maxFrequency = 0;
        int maxLastOccurrenceIndex = -1;
        
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            int lastIdx = lastOccurrenceIndex.get(word);
            
            if (frequency > maxFrequency || (frequency == maxFrequency && lastIdx > maxLastOccurrenceIndex)) {
                maxFrequency = frequency;
                maxLastOccurrenceIndex = lastIdx;
                mostFrequentWord = word;
            }
        }
        
        System.out.println(mostFrequentWord);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        
        Solution obj = new Solution();
        obj.mostFrequent(arr, n);
        
        sc.close();
    }
}
