import java.util.*;

class Main {
    public static int sqrt(int A) {
        if (A == 0 || A == 1) return A; 
        
        int left = 1, right = A;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            
            if (mid <= A / mid) {
                left = mid + 1;
                result = mid; 
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        System.out.println(sqrt(A));
    }
}
