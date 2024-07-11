import java.util.*;

class Accio {
    static int[] HeightProblem(int n, int[] arr) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[stack.peek()];
            }
            
            stack.push(i);
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int[] ans = obj.HeightProblem(n, arr);
        for(int i = 0; i < n; ++i) {
            System.out.print(ans[i] + " ");
        }
        System.out.println(); 
    }
}
