import java.util.*;

class Accio {
    public void linesStars(int m, int n) {
        //Lines and Stars
       for(int i=0; i<m ; i++)
           {
               for(int j=0; j<n; j++)
                   {
                       System.out.print("*");
                   }
               System.out.println();
           }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Accio Obj = new Accio();
        Obj.linesStars(m, n);
        sc.close();
    }
}