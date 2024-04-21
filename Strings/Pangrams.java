import java.util.*;
import java.io.*;

public class Main {
     public  static void isPangram(String s)
      {
          boolean isPresent[]= new boolean[26];

          int n = s.length();
          for(int i=0; i<n; i++)
              {
                  char c= s.charAt(i);
                  if(c>='a' && c<='z')
                  {
                      int index = c-'a';
                      isPresent[index]=true;
                  }else if(c>='A' && c<='Z')
                  {
                      int index = c-'A';
                      isPresent[index]=true;
                  }
              }
                  for(int j=0; j<26; j++)
                      {
                          if(isPresent[j]==false)
                          {
                              System.out.print("not pangram");
                              return;
                          }
                      }
                  System.out.print("pangram");
              }
public static void main(String args[]) {
   Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);
        
    }
}