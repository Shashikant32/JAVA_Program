import java.util.*;

class Solution {
    public boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true; // Mark room 0 as visited initially
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // Enqueue room 0
        
        while (!queue.isEmpty()) {
            int currRoom = queue.poll(); // Dequeue a room
            
            for (int key : rooms.get(currRoom)) {
                if (!visited[key]) {
                    visited[key] = true; // Mark the room as visited
                    queue.offer(key); // Enqueue the room
                }
            }
        }
        
        // Check if all rooms have been visited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> rooms = new ArrayList<>();
        
        // Input the rooms and their keys
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(); // Number of keys in the room
            ArrayList<Integer> keys = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                keys.add(sc.nextInt());
            }
            rooms.add(keys);
        }
        // Create an instance of the Solution class
        Solution obj = new Solution();
        
        // Check if all rooms can be visited
        if (obj.canVisitAllRooms(rooms)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
