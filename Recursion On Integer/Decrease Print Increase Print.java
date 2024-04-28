import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
    printDI(n);
  }

  public static void printDI(int n) {
    if(n==0)
    {
        return ;
    }
      System.out.println(n);
      printDI(n-1);
      System.out.println(n);
  }
}