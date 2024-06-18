
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();

        int k=sc.nextInt();

        Accio ob = new Accio();
        ArrayList<Integer> ans = ob.searchRange(arr, k,N);
        for(int x:ans)
        System.out.print(x+" ");
        
        System.out.println();
    
    }
}

class Accio {
    public ArrayList<Integer> searchRange(int[] arr, int target, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int firstOccurrence = findFirstOccurrence(arr, target, n);
        int lastOccurrence = findLastOccurrence(arr, target, n);
        
        result.add(firstOccurrence);
        result.add(lastOccurrence);
        
        return result;
    }
    
    private int findFirstOccurrence(int[] arr, int target, int n) {
        int left = 0;
        int right = n - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; 
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private int findLastOccurrence(int[] arr, int target, int n) {
        int left = 0;
        int right = n - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}