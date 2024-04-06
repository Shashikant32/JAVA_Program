import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        // Array Problem 1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        int ans=ArrayProblem1(n,arr);
        System.out.println(ans);
    }

    public static int ArrayProblem1(int n, int[] arr){
        int ans =0;
        int maxValue= arr[0];
        for(int i=1; i<arr.length; i++)
            {
                if(arr[i]>maxValue)
                {
                    maxValue = arr[i];
                    ans = i;
                }
            }
        return ans;
    }
}