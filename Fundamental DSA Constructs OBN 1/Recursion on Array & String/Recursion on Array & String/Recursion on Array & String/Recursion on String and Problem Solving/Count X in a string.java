import java.util.Scanner;

public class Main {
    static int countX(String str, int i, int n) {
        if(i==n)
        {
            return 0;
        }
        if(str.charAt(i)== 'x')
        {
            return 1+ countX(str,i+1,n);
        }
        return countX(str,i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n=str.length();
        System.out.println(countX(str,0,n));
    }
}
