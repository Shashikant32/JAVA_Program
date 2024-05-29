import java.util.*;

class Solution {
    static void printMax(int arr[], int N, int K) {
        Deque<Integer> deque = new LinkedList<>();
    
        for (int i = 0; i < K; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.print(arr[deque.peekFirst()] + " ");
        
       
        for (int i = K; i < N; i++) {
            
            while (!deque.isEmpty() && deque.peekFirst() <= i - K) {
                deque.removeFirst();
            }
           
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
           
            deque.addLast(i);
            
            System.out.print(arr[deque.peekFirst()] + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        Obj.printMax(arr, n, k);
        System.out.println();
    }
}
