import java.util.*;

class Accio {
    public int longestOnes(int[] A, int B) {
        int left = 0;
        int maxLength = 0;
        int countZeros = 0;
        
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                countZeros++;
            }
            
            while (countZeros > B) {
                if (A[left] == 0) {
                    countZeros--;
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        
        Accio Obj = new Accio();
        System.out.println(Obj.longestOnes(A, B));
        
        sc.close();
    }
}
