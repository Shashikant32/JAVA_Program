import java.io.*;
import java.util.*;

public class Main {

    public static int searchInsert(int[] a, int b) {
        int s = 0;
        int e = a.length-1;
      while(s<=e)
          {
              int mid = s+(e-s)/2;
              if(a[mid]==b)
              {
                  return mid;
              }
              if(a[mid]>b)
              {
                   e = mid - 1;
              }else
              {
                    s = mid + 1;
              }
             
          }
         return s;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A,B));
    }
}