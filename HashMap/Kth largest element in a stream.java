import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            
            minHeap.offer(num);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                result.add(minHeap.peek());
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
}
