import java.io.*;

public class Main {

    // Recursive function to place items in boxes
    private static void placeItems(int[] boxes, int boxIndex, boolean[] usedItems, int totalItems, int itemsPlaced) {
        // Base case: If all items are placed
        if (itemsPlaced == totalItems) {
            // Print the current configuration
            for (int i : boxes) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        // Base case: If we've reached the end of the boxes
        if (boxIndex >= boxes.length) {
            return;
        }


        // Option 2: Try placing each item in the current box
        for (int item = 1; item <= totalItems; item++) {
            if (!usedItems[item - 1]) {
                boxes[boxIndex] = item;
                usedItems[item - 1] = true;
                placeItems(boxes, boxIndex + 1, usedItems, totalItems, itemsPlaced + 1);
                usedItems[item - 1] = false; // Backtrack
                boxes[boxIndex] = 0; // Remove item from the current box
            }
        
        }
        // Option 1: Leave the current box empty
        placeItems(boxes, boxIndex + 1, usedItems, totalItems, itemsPlaced);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        int[] boxes = new int[nboxes]; // Array to represent boxes
        boolean[] usedItems = new boolean[ritems]; // To track used items
        placeItems(boxes, 0, usedItems, ritems, 0);
    }
}
