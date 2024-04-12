import java.io.*;
import java.util.*;

public class Main {
    //A Contest
    public static void printFindParticipants(int[] arr, int n, int k) {
        int count = 0;
        int scores = arr[k - 1]; 
        
        for (int i = 0; i < n; i++) {
            if (arr[i] >= scores && arr[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
      	int k=sc.nextInt();
      	int[] arr= new int[n];

      	for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
            
        printFindParticipants(arr,n,k);
        sc.close();
        
    }
}