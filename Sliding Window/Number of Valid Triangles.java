import java.util.*;

public class Main {

    public static int ValidTriangles(int n, int[] arr) {
       
        if (n < 3) {
            return 0;
        }

        Arrays.sort(arr);
        
        int count = 0;

        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int ans = ValidTriangles(n, arr);
        System.out.println(ans);
    }
}
