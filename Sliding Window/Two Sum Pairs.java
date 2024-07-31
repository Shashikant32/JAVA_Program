import java.util.*;

public class Main {

    public static List<List<Integer>> twoSum(int[] arr, int target) {
        Arrays.sort(arr);

        Set<List<Integer>> resultSet = new HashSet<>();
        
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                resultSet.add(Arrays.asList(arr[left], arr[right]));
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        List<List<Integer>> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList, (a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            } else {
                return a.get(1) - b.get(1);
            }
        });

        return resultList;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int target = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            StringBuilder ans = new StringBuilder();
            for (int val : list) {
                ans.append(val).append(" ");
            }
            finalResult.add(ans.toString().trim());
        }
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}
