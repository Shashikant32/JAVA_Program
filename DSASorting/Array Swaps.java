import java.io.*;
import java.util.*;
public class Main {
    static String arraySwaps(int arr[],int n,int x)
    {
        boolean sorted = true;
        for(int i=1;i<n;i++)
            {
                if(arr[i]<arr[i-1])
                {
                    if(i-1 >=x || n-i>=x)
                    {
                    int temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                   
                    }else
                    {
                      sorted=false;  
                         break; 
                    }
                    
                }
            }
        if(sorted)
        {
            return "YES";
        }else
        {
            return "NO";
        }
        
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        String ans = arraySwaps(a,n,x);
        System.out.println(ans);
    }
}