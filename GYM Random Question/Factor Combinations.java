import java.util.*;

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        findFactors(n, 2, new ArrayList<>(), result);
        return result;
    }

    private void findFactors(int n, int start, List<Integer> current, List<List<Integer>> result) {
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                current.add(i);
                findFactors(n / i, i, current, result);
                current.remove(current.size() - 1);
            }
        }
        if (!current.isEmpty()) {
            current.add(n);  
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);  
       }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> result = Obj.getFactors(n);
        Collections.sort(result, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }
        sc.close();
    }
}
