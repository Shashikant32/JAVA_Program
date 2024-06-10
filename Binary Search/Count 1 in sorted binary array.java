import java.util.*;

class Solution {
    static int count1(int size, int arr[]) {
        int low = 0;
        int high = size - 1;
        int lastIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == 1) {
                lastIndex = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        if (lastIndex == -1) {
            return 0;
        }
        return lastIndex + 1;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n, array));
    }
}
