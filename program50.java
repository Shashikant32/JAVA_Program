import java.io.*;
import java.util.*;

class Main
{
    //Sum of Array
    static int findSum(int arr[],int N){
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        return sum;

    }
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // array size
        int arr[]=new int[N] ;// creating array of size N

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt(); // taking input of array elements
        }

        int ans=findSum(arr,N);
        System.out.println(ans); // printing the sum
    }
}