import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputLine[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        int start[] = new int[n];
        int end[] = new int[n];
        
        inputLine = br.readLine().trim().split(" ");
        for(int i = 0; i < n; i++)
            start[i] = Integer.parseInt(inputLine[i]);
        
        inputLine = br.readLine().trim().split(" ");
        for(int i = 0; i < n; i++)
            end[i] = Integer.parseInt(inputLine[i]);
        
        System.out.println(new Solution().solve(start, end, n));
    }
}

class Solution
{
    public int solve(int start[], int end[], int n)
    {
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = end[i];
        }
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int lastEndTime = 0;
        
        for (int i = 0; i < n; i++) {
            if (activities[i][0] > lastEndTime) {
                lastEndTime = activities[i][1];
                count++;
            }
        }
        
        return count;
    }
}
