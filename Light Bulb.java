import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // perfect squares <= n
        for (int i = 1; i * i <= n; i++) {
            System.out.println(i * i);
        }
    }
}
