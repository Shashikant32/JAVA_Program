
import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
        int [] p = new int[1001];

        //fill passenger inside p

        for(int i=0; i<trips.length; i++)
            {
                int num = trips[i][0];
                int from = trips[i][1];
                int t = trips[i][2];
                p[from] += num;
                if(t<1000)
                {
                    p[t+1] -= num;
                }
             }
                // cal pref sum of this p array
                for(int i=1; i<=1000; i++)
                    {
                        p[i] += p[i-1];
                        
                    }
                // check if num of passenger are <= capacity then
                for(int i=0; i<=1000; i++)
                    {
                        if(p[i] > capacity )
                        {
                            return false;
                        }
                        
                    }
                 return true;
    }
}