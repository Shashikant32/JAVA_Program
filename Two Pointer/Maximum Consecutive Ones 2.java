import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k)
    {
        int l = 0, r= 1, ans=0;
        if(arr[l]==0) k--;
        while(r<n)
            {
                while(k<=0 && arr[r]==0)
                    {
                        if(arr[l]==0)
                        {
                            k++;
                        }
                        l++;
                    }
                if(arr[r]== 0) k--;
                ans = Math.max(r-l+1,ans);
                r++;
            }
        return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}