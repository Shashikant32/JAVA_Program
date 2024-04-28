import java.io.*;
import java.util.*;
public class Main {
  public static long multiplyRecursively(int n, int m) {
    if(m==0)
    {
        return 0;
    }
      long fact=multiplyRecursively(n,m-1);
     return n+fact; 
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    long ans= multiplyRecursively(n, m);
    System.out.println(multiplyRecursively(n, m));
  }
}