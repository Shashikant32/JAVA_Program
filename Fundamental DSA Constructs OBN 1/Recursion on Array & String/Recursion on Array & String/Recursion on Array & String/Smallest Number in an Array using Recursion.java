import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(recforMin(arr, 0));
    }

	public static int recforMin(int[] arr, int idx) {
        if(idx==arr.length-1)
        {
            return arr[idx];
        }
        // int currElement = arr[idx];
        // int restofThemain=recforMin(arr,idx+1);

        // return Math.min(currElement,restofThemain);
         return Math.min(arr[idx],recforMin(arr,idx+1));//diract return
        
    }
}