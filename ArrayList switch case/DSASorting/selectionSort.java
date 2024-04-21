import java.util.*;

public class Main {
    public static int[] SelectionSort(int[] arr) {
        int ans=arr.length;
      for(int i=0; i<ans; i++)
      {
          int index=i;// mana hai ki ith index is the smallest element
          for(int j=i+1;j<ans; j++)// bache huye array se sabse chhota element dhundha
          {
              if(arr[j]<arr[index])
              {
                  index=j;
              }
          }
          // swap arr[index] and arr[i]
          int temp=arr[i];
          arr[i]=arr[index];
          arr[index]=temp;
      }
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = SelectionSort(arr);

        for(int a : ans)
            System.out.print(a + " ");
    }
}