import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll(); 
                minHeap.add(num); 
            }
            
            if (minHeap.size() < k) {
                System.out.print("-1 ");
            } else {
                System.out.print(minHeap.peek() + " ");
            }
        }
        
        sc.close();
    }
}
