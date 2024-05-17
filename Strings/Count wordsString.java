import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    String p = sc.nextLine();
    while (t > 0) {
      String s = sc.nextLine();
      System.out.println(countWords(s));
      t--;
    }
  }
  public static int countWords(String s) {
    int count=0;
      int n= s.length();
    for(int i=1; i<s.length(); i++)
        {
            char c = s.charAt(i);
            char prev = s.charAt(i-1);
            if(c==' ' && (prev >= 'a' && prev <= 'z'))
            {
                count++;
            }
            if(i==n-1 && (c>='a' && c<='z'))
            {
                count++;
            }
        }
      return count;
  }
}