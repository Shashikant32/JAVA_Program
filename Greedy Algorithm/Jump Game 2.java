import java.util.Scanner;

class Solution {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        
        if (n <= 1) {
            return 0;
        }
        
        if (arr[0] == 0) {
            return -1; 
        }

        int jumps = 0;       
        int currEnd = 0; 
        int farthest = 0;   
        
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
                
                if (currEnd >= n - 1) {
                    break;
                }
            }
        }
        return jumps;
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
        System.out.println(Solution.minJumps(arr));
    }
}
