import java.util.*;

public class Main {

  public static void main(String[] args) throws Throwable {
    //Switch Case Problem 3
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c=a%b;
   switch(c)
       {
           case 0:
               System.out.println("Remainder is too small");
               break;
            case 1:
               System.out.println("Remainder is small");
               break;
            case 2:
               System.out.println("Remainder is large");
               break;
            default:
               System.out.println("Remainder is too large");
       }
  }
}