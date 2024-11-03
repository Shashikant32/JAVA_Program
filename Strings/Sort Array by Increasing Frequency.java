import java.util.*;

class Solution {
    public void sortByFrequency(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        Collections.sort(entryList, (a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey(); // Sort by value in descending order if frequency is the same
            }
            return a.getValue() - b.getValue(); // Sort by frequency in ascending order
        });

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int frequency = entry.getValue();
            int number = entry.getKey();
            for (int i = 0; i < frequency; i++) {
                resultList.add(number);
            }
        }

         for (int num : resultList) {
            System.out.print(num + " ");
        }
        System.out.println(); // for new line after output
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        obj.sortByFrequency(arr);
        sc.close();
    }
}
