import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // Calculate nPr
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
   
   public static int getValueInBase(int n, int r){
    int result = 1;
       int fact =1;
     for(int i=0; i<n-r; i++)
         {
             fact *=(n-i);
         }
       for(int i=0;i<r; i++)
           {
               result *=(n-i);
           }
       return result;
   }
  }