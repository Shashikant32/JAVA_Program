import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int smallerEqual(int[] A, int B) {
      int left = 0;
        int right = A.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] <= B) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}

public class Main {

  public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  int[] A = new int[n];
	  for(int i=0;i<n;i++){
          A[i] = sc.nextInt();
	  }
	  int B = sc.nextInt();
      Solution Obj = new Solution();
      System.out.println(Obj.smallerEqual(A,B));
	}
}