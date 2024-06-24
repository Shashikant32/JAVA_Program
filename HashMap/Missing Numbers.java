import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        Map<Integer, Integer> frequencyMapArr = new HashMap<>();
        Map<Integer, Integer> frequencyMapBrr = new HashMap<>();

        for (int num : arr) {
            frequencyMapArr.put(num, frequencyMapArr.getOrDefault(num, 0) + 1);
        }

        for (int num : brr) {
            frequencyMapBrr.put(num, frequencyMapBrr.getOrDefault(num, 0) + 1);
        }

        List<Integer> missingNumbers = new ArrayList<>();

        for (int num : frequencyMapBrr.keySet()) {
            int countInArr = frequencyMapArr.getOrDefault(num, 0);
            int countInBrr = frequencyMapBrr.get(num);

            if (countInArr != countInBrr) {
                missingNumbers.add(num);
            }
        }

        Collections.sort(missingNumbers);

        if (missingNumbers.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int num : missingNumbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        obj.missingNumbers(n, arr, m, brr);
    }
}
