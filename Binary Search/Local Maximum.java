import java.util.*;

class Accio {
    static int LocalMaximum(int N, int[] A) {
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] > A[mid + 1]) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        
        Accio obj = new Accio();
        int ans = obj.LocalMaximum(n, arr);
        
        System.out.println(ans);
    }
}
