import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);

        int start[] = new int[n];
        int end[] = new int[n];

        inputLine = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++)
            start[i] = Integer.parseInt(inputLine[i]);

        inputLine = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) 
            end[i] = Integer.parseInt(inputLine[i]);
            
        int ans = new Solution().maxMeetings(start, end, n);
        System.out.println(ans);
    }
}

class Solution {
    public int maxMeetings(int start[], int end[], int n) {
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);
        
        int count = 0;
        int lastEndTime = -1;
        
        for (Meeting meeting : meetings) {
            if (meeting.start > lastEndTime) {
                count++;
                lastEndTime = meeting.end;
            }
        }
        
        return count;
    }
}

class Meeting {
    int start, end;
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
