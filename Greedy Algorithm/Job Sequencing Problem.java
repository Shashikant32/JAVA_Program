import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        Job[] arr = new Job[n];
        
        String[] inputLine = br.readLine().trim().split(" ");
        for (int i = 0, k = 0; i < n; i++) {
            int id = Integer.parseInt(inputLine[k++]);
            int deadline = Integer.parseInt(inputLine[k++]);
            int profit = Integer.parseInt(inputLine[k++]);
            arr[i] = new Job(id, deadline, profit);
        }
        
        Solution ob = new Solution();
        int[] res = ob.solve(arr, n);
        System.out.println(res[0] + " " + res[1]);
    }
}

class Solution {
    int[] solve(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        
        boolean[] slot = new boolean[maxDeadline + 1];
        
        int countJobs = 0;
        int totalProfit = 0;
        
        for (Job job : arr) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    countJobs++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        return new int[] { countJobs, totalProfit };
    }
}
