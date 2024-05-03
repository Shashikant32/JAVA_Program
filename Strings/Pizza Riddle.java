import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();  
    int a = sc.nextInt();  
    int b = sc.nextInt();  
    int c = sc.nextInt();  
    PizzaBase answer = new PizzaBase(a,b,c);
    for(int i=0;i<n;i++)
    {
      int q = sc.nextInt(); 
      System.out.println(answer.checkBase(q));
    }
  }
}

class PizzaBase {
    private int bigCount;
    private int mediumCount;
    private int smallCount;
 
    public PizzaBase(int big, int medium, int small) {
        this.bigCount = big;
        this.mediumCount = medium;
        this. smallCount = small;
    }
    
    public boolean checkBase(int pizzaSize) {
        switch(pizzaSize)
            {
                case 1:
                    if(bigCount>0)
                    {
                        bigCount--;
                        return true;
                    }
                    break;
                case 2:
                    if(mediumCount > 0)
                    {
                        mediumCount--;
                        return true;
                    }
                    break;
                case 3:
                    if(smallCount > 0)
                    {
                        smallCount--;
                        return true;
                    }
                    break;
            }
        return false;
    }
}
