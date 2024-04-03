import java.util.*;

 public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // HCF of Two Numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
    
        int hcf=HCF(a,b);
        System.out.println(hcf);
        
    }
  public static int HCF(int a,int b)
    {
        while(b!=0)
            {
                int temp =b;
                b=a%b;
                a=temp;
            }
        return a;
    }
}
