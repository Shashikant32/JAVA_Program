import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count7(n));
        sc.close();
    }

    public static int count7(int n) {
        if(n==0)
        {
            return 0;
        }
        int digi=n%10;
        if(digi==7)
        {
            return 1 + count7(n/10);
        }
        return count7(n/10);
    }
}