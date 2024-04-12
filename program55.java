import java.util.*;

class Accio{
    static int OddArraySum(int n,int[] arr){
        // Odd Array Sum
        int oddSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddSum += arr[i];
            }
        }
       return oddSum;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int ans = obj.OddArraySum(n,arr);
        System.out.println(ans);
    }
}