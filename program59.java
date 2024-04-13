import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Stopwatch
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        int Time = 0;
        boolean isRunning = false;
        int previousTime = 0;
        
        for (int i = 0; i < N; i++) {
            int currentTime = scanner.nextInt();
            
            if (isRunning) {
                Time += currentTime - previousTime;
            }
            isRunning = !isRunning;
            previousTime = currentTime;
        }

        if (N % 2 == 1) {
            System.out.println("still running");
        } else {
            System.out.println(Time);
        }
    }
}
