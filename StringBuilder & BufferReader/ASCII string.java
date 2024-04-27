import java.io.*;
import java.util.*;
public class Main {
  
  public static String solution(String str) {
     StringBuilder s =new StringBuilder();
      s.append(str.charAt(0));
      for(int i=1; i<str.length();i++)
          {
              int diff = str.charAt(i)-str.charAt(i-1);
              s.append(diff);
              s.append(str.charAt(i));
              // s= s+ diff;
              // s=s+ str.charAt();
          }
      return s.toString();
      
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(solution(str));
  }
}