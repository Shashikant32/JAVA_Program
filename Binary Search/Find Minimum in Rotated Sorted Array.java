// Java program to find minimum element in a sorted and rotated array

import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int arr[], int low, int high)
    {
        int leftEnd=low;
        while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(arr[mid]<arr[mid-1])
                    {
                        return arr[mid];
                    }
                    if(arr[mid]>arr[leftEnd])
                    {
                        low = mid+1;
                    }else
                    {
                        high = mid-1;
                    }
            }
        
           return low;
    }
}
class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}yyy