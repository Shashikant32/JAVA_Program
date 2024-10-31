import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> ranges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> range = new ArrayList<>();
            range.add(sc.nextInt());
            range.add(sc.nextInt());
            ranges.add(range);
        }
        ArrayList<ArrayList<Integer>> ans = Solution.mergeRanges(ranges);
        int m = ans.size();
        System.out.println(m);
        for(int i = 0; i < m; i++) {
            System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}

class Solution {
    static ArrayList<ArrayList<Integer>> mergeRanges(ArrayList<ArrayList<Integer>> ranges) {
        Collections.sort(ranges, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        ArrayList<ArrayList<Integer>> merged = new ArrayList<>();
        for (ArrayList<Integer> range : ranges) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < range.get(0)) {
                merged.add(new ArrayList<>(range));
            } else {
                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), range.get(1)));
            }
        }
        return merged;
    }
}
