import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        int a = sc.nextInt();  
        int b = sc.nextInt();  
        int c = sc.nextInt();  
        
        PizzaBase answer = new PizzaBase(a, b, c);
        
        for(int i = 0; i < n; i++) {
            int q = sc.nextInt(); 
            System.out.println(answer.checkBase(q));
        }
        
        sc.close();
    }
}

class PizzaBase {
    private int big;
    private int medium;
    private int small;
    
    public PizzaBase(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean checkBase(int pizzaSize) {
        if (pizzaSize == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } else if (pizzaSize == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (pizzaSize == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }
}
