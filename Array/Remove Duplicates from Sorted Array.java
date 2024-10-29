
import java.util.*;

public class Main{
    public static void main(String[] args)
    {
        int n,x;
        Scanner in = new Scanner(System.in);
	    n = in.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=in.nextInt();
        Solution obj=new Solution();
        int k=obj.solve(nums);

        for(int i=0;i<k;i++)
        System.out.print(nums[i]+" ");

        System.out.println();
    }
    
}

class Solution{
    
    static int solve(int nums[])
    {
        // your code here
        if(nums.length == 0)
        {
            return 0;
        }
        int k=1;

        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] !=nums[k-1])
            {
                nums[k]= nums[i];
                k++;
            }
        }
        return k;
        
    }
}