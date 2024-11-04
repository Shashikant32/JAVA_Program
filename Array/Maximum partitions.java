import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int arr [] = new int[sizeOfArray];
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Solution obj = new Solution();
		    int ans = obj.maxPartitions(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}

class Solution {
    public static int maxPartitions(int arr[], int n) {
        int partitions = 0;
        int maxElement = -1;

        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);

            if (maxElement == i) {
                partitions++;
            }
        }
        
        return partitions;
    }
}



