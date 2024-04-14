import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Check if array is Increasing
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
   
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            boolean isIncreasing = checkIncreasing(arr);
            
            if (isIncreasing) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
    
    public static boolean checkIncreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
