import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution obj = new Solution();
        while (q-- > 0) {
            int input = sc.nextInt();
            if (input == 1) {
                int value = sc.nextInt();
                obj.addNum(value);
            } else {
                List<int[]> arr = obj.getIntervals();
                for (int i = 0; i < arr.size(); i++) {
                    for (int j = 0; j < arr.get(i).length; j++)
                        System.out.print(arr.get(i)[j] + " ");
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}

class Solution {
    private List<int[]> intervals;

    public Solution() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        List<int[]> newIntervals = new ArrayList<>();
        int[] newInterval = new int[] {val, val};
        int i = 0;
        while (i < intervals.size()) {
            int[] interval = intervals.get(i);
            if (interval[1] + 1 < val) {
                newIntervals.add(interval);
            } else if (interval[0] - 1 > val) {
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            i++;
        }
        newIntervals.add(newInterval);
        while (i < intervals.size()) {
            newIntervals.add(intervals.get(i++));
        }
        intervals = newIntervals;
    }

    public List<int[]> getIntervals() {
        return intervals;
    }
}
