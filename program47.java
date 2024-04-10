import java.util.*;

public class Main {
    static void printOperations(int x, int y, int z){
        // AS Basic DataTypes 1
        int Op1 = x + y + z;
        int Op2 = x * y - z;
        System.out.println(Op1);
        System.out.println(Op2);
    }
	
	public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        printOperations(x, y, z);
    }
}