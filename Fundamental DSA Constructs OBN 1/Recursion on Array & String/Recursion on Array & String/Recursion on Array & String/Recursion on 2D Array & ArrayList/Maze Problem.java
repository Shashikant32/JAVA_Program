import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> ans = new ArrayList<>();
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        //when go to out of the bouns then
        if (sr > dr || sc > dc) {
            return;
        }
        // horizontal
        for(int i = 1; i <= dc; i++) {
            printMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
        }
         // vertical
        for(int i = 1; i <= dr; i++) {
            printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
        }
        // diagonal
        for(int i = 1; i <= dc && i <= dr; i++) {
            printMazePaths(sr + i, sc + i, dr, dc, psf + "d" + i);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}