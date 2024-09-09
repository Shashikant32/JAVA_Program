import java.io.*;

public class Main {

    // generate all configurations
    public static void combinations(int cb, int tb, int itpsf, int ts, String asf) {
        //if all items are placed, print the configuration
        if (itpsf == ts) {
            // Fill the rest of the boxes with empty slots
            String result = asf + "-".repeat(tb - asf.length());
            System.out.println(result);
            return;
        }
        
        // if we've considered all boxes
        if (cb > tb) {
            return;
        }
        
        // Recursive case: try placing an item in the current box
        combinations(cb + 1, tb, itpsf + 1, ts, asf + "i");
        
        // Recursive case: skip the current box and move to the next box
        combinations(cb + 1, tb, itpsf, ts, asf + "-");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // No. of boxes
        int R = Integer.parseInt(br.readLine()); //No. of items
        combinations(1, N, 0, R, "");
    }
}
