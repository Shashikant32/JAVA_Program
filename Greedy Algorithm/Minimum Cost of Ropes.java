import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        for (long length : arr) {
            minHeap.add(length);
        }
        
        long totalCost = 0;
        
        while (minHeap.size() > 1) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            
            long cost = first + second;
            totalCost += cost;
            
            minHeap.add(cost);
        }
        
        return totalCost;
    }
}

class Main {
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        Integer nextInt() { 
            return Integer.parseInt(next()); 
        }
        
        Long nextLong() { 
            return Long.parseLong(next()); 
        }
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = sc.nextInt();
        long arr[] = new long[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        
        out.println(new Solution().minCost(arr, n));
        out.flush();
    }
}
