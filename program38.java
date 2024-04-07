import java.util.*;
import static java.lang.Math.ceil;
//Sigma of Equation
/*class Solution {
    public long SigmaEquation(int n ) 
    {
        
        long sum = 0;
        for(long i=1; i<=n; i++)
            {
                long num = (i+1)*(i+1)-(3*i+1)+i;
                sum+=num;
            }
            System.out.println(sum);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.SigmaEquation(n));

    }
}
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += ((i + 1) * (i + 1)) - (3 * i + 1) + i;
        }
        
        System.out.println(sum);
    }
}