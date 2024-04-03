import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Check Prime
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        if(n%2==1)
        {
           System.out.println(n+ " is a prime number");
        }else
        {
            System.out.println(n+ " is not a prime number");
        }
		sc.close();
    }
}