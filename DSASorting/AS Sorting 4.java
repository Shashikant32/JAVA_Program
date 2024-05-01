import java.util.*;
public class Main {
    static int sorting4(int n, int[] arr, int l){
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[k] - arr[i] <= l) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int l = sc.nextInt();

        int ans = sorting4(n, arr, l);
        System.out.println(ans);
    }
}
