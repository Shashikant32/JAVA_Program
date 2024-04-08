import java.util.*;

public class Main {
    
    public static void findGeometricTriplets(int arr[], int n) {
        // Find Geometric Triplets
        for(int i=0; i<=n-3;i++)
            {
                for(int j=i+1; j<=n-2; j++)
                    {
                        for(int k=j+1;k<n;k++)
                            {
                                int a =arr[i];
                                int b =arr[j];
                                int c =arr[k];
                                if(b*b==a*c)
                                {
                                    System.out.println(a+ " " +b +" "+c);
                                }
                            }
                    }
            }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        findGeometricTriplets(arr, N);
        sc.close();
    }
}