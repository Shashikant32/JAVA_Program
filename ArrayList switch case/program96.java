import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Throwable {
    //Mathematical Operations
      Scanner scanner=new Scanner(System.in);
      int A= scanner.nextInt();
      int B= scanner.nextInt();

      int sum=A+B;
      int difference=A-B;
      int product=A*B;
      int quotient=A/B;
      int remainder=A%B;

      System.out.println(sum);
      System.out.println(difference);
      System.out.println(product);
      System.out.println(quotient);
      System.out.println(remainder);

      scanner.close();
  }
}