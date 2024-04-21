import java.util.Arrays;
public class Main {
    public static void main(String args[]) {
    int arr[]={13,17,2,5,11,9};
    int ans=arr.length;
    for(int i=0;i<ans;i++)
    {
        boolean swapp=false;
        for(int j=0; j<ans-1-i; j++)
        {
            if(arr[j]>arr[j+1])// sign change for incrising/discring
            {
                int tmp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=tmp;
                swapp=true;
            }
        }
        // when array alrady sort ,there will be no swapp
        if(swapp==false)
        {
            break;
        }
    }
    for(int i=0; i<ans; i++)
      {
          System.out.print(arr[i]+ " ");
      }
     
    }
}