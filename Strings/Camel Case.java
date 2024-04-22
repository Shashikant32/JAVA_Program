import java.util.*;

class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      camelCase(s);
      System.out.println(); 
      
    }
  }

  static void camelCase(String s) {
      int n=s.length();
        for(int i=0; i<n; i++)
            {
                char c=s.charAt(i);
                if(c=='_')
                {
                    char nextChar = s.charAt(i+1);
                    System.out.print((char)(nextChar -'a'+'A'));
                    i++;
                }else
                {
                    System.out.print(c);
                }
            }
  }
}