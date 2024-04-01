import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // Which angled triangle
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        int maxSids = Math.max(Math.max(a, b), c);
        int sum = a* a + b*b + c*c;
        int triangle;
        if(2* maxSids * maxSids < sum)
        {
            triangle=1;
        }else if(2* maxSids * maxSids == sum)
        {
            triangle=2;
        }else
        {
            triangle=3;
        }
        System.out.println(triangle);
    }
	
}