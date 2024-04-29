import java.util.Scanner;

public class Main {
    
    public static void printZigZag(int n) {
          
          if(n<=0)
          {
              return;
          }
        System.out.print(n+ " ");
        printZigZag(n-1);
        System.out.print(n+ " ");
        printZigZag(n-1);
        System.out.print(n+ " ");
        
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printZigZag(n);
        scanner.close();
    }
}
