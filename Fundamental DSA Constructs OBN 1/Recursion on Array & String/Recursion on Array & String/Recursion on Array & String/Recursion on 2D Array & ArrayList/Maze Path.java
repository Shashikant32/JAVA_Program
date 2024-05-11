import java.util.*;

public class Main { 
   // store paths in ans array
    static ArrayList<String> ans = new ArrayList<>();

    static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
          if (sr == dr && sc == dc) {
            ans.add(psf);
            return;
        }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        printMazePaths(0, 0, n - 1, m - 1, "");
        Collections.sort(ans);

        for(String path : ans){
            System.out.println(path);
        }
    }
}
