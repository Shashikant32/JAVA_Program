import java.util.*;

public class Main {

  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String str = sc.nextLine();
    toggleCase(n, str);
  }

  static void toggleCase(int n, String str) {
    for(int i=0; i<n; i++)
    {
        char c = str.charAt(i);
        if(c >= 'a' && c<= 'z')
        {
            char x =(char)(c-'a'+'A');// for the UpperCase print
            System.out.print(x);
        }
        else if(c >= 'A' && c<= 'Z')
        {
            char x =(char)(c-'A'+'a');// for the LowerCase print
            System.out.print(x);
        } else
        {
            System.out.print(c);
        }
        }
       
    }
  
}