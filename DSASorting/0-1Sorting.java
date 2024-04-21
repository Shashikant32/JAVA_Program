import java.util.*;

public class Main {
	 static int[] Sorting01(int n,int[] arr){

         // int count0=0;
         // int count1=0;
         // for(int i=0;i<n; i++)
         //    {
         //      if(arr[i]==0)
         //      {
         //          count0++;
         //      }else
         //      {
         //          count1++;
         //      }
         //    }
         // int i=0;
         // for(i=0; i<count0; i++)
         //     {
         //         arr[i]=0;
         //     }
         // for(; i<n;i++)
         //     {
         //         arr[i]=1;
         //     }
         // return arr;

         int left=0;
         int right=n-1;

         while(left<right)
             {
                 while(arr[left]==0 && left<right)//agr 1 se stert krna hai to yaha pe 1
                     {
                         left++;
                     }
                 while(arr[right]==1 && left<right)//yaha pe 0
                     {
                         right--;
                     }
                 //Swap
                 int temp=arr[left];
                 arr[left]=arr[right];
                 arr[right]=temp;
             }
         return arr;
    }
	
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        int[] ans=Sorting01(n,arr);
        for(int i=0;i<n;++i){
            System.out.print(ans[i] + " ");
        }
    }
}