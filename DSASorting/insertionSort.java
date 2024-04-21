import java.util.Arrays;
public class Main {
    public static void main(String args[]) 
    {
        int arr[]={36,16,20,23,4,5,9};
        int ans=arr.length;
        for(int i=0;i<ans;i++)
        {
            int currVal= arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>currVal)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=currVal;
           
        }
        for(int i=0; i<ans; i++)
        {
            System.out.print(arr[i]+ " ");
        }
    }
}