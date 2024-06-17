import java.util.*;

class Accio {
    static int MinElement(int n, int[] arr) {
        int start = 0, end = n - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] <= arr[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return arr[start];
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
        
        Accio obj = new Accio();
        int ans = obj.MinElement(n, arr);
        System.out.println(ans);
        
        sc.close();
    }
}
