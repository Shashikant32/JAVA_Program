import java.io.*;
import java.util.*;

class Solution {
    public static int[] leftMax(int arr[] , int n)
    {
        int lMax[] = new int[n];
        lMax[0] = arr[0];
        for(int i=1; i<n; i++)
            {
                 lMax[i] = Math.max(lMax[i-1], arr[i]);
            }
        return lMax;
    }
    public static int[] rightMax(int arr[] , int n)
    {
        int rMax[] = new int[n];
        rMax[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--)
            {
                 rMax[i] = Math.max(rMax[i+1], arr[i]);
            }
        return rMax;
    }
    public void TappingWater(int[] arr, int n) {
     int [] lMax = leftMax(arr,n);
     int [] rMax = rightMax(arr,n);
     
       int totalWaterTrapped =0;
        for(int i=0; i<n; i++)
            {
                int minHeight = Math.min(lMax[i] , rMax[i]);
                if(minHeight >= arr[i])
                {
                    totalWaterTrapped +=(minHeight - arr[i]);
                }
            }
        System.out.println(totalWaterTrapped);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}