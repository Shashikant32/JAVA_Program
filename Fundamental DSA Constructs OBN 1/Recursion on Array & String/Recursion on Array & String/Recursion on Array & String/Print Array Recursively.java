import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        PrintArray(arr, n);
    }

	public static void PrintArray(int[] arr, int n) {
        if(n==0)
        {
            return;
        }
        PrintArray(arr,n-1);
        System.out.print(arr[n-1]+ " ");
      // index(arr,0,n);
    }
    // static void index(int[] arr, int i,int n)

    // {
    //     if(i==n)
    //   {
    //       return;
    //   }
    //     System.out.print(arr[i] + " ");
    //     index(arr,i+1,n);
    // }
}