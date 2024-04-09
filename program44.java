import java.util.*;

public class Main {
    static int printCount(int a, int b, int c){
        int count = 0;
        //AS Basic DataTypes 2
        if (a < 0) {
            count++;
        }
        if (b < 0) {
            count++;
        }
        if (c < 0) {
            count++;
        }
        
        return count;
    }

	public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(printCount(a, b, c));
    }
}