import java.io.*;
import java.util.*;


public class Main {
        //Divisible Sum Pairs
    public static int divisibleSumPairs(int arr[], int n, int k){
         int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = divisibleSumPairs(arr, n, k);
        System.out.print(result);        
        System.out.println('\n');
    }
}