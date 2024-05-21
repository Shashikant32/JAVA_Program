import java.util.*;

class Accio {
    public int HouseRobber(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);
        
        int robFirstToSecondLast = robLinear(arr, 0, arr.length - 2);
        int robSecondToLast = robLinear(arr, 1, arr.length - 1);
        return Math.max(robFirstToSecondLast, robSecondToLast);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Accio Obj = new Accio();
        System.out.println(Obj.HouseRobber(arr));
    }
}
