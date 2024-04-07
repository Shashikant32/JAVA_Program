import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Power of a Number
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int result=1;
        if(b>=0)
        {
            for(int i=0; i<b;i++)
                {
                    result*=a;
                }
        }else
        {
            for(int i=0; i<b; i++)
                {
                    result*=a;
                }
            result=1/result;
        }
        System.out.println(result);
    }

}