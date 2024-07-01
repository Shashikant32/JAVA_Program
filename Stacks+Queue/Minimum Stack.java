import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int q = sc.nextInt();
            Solution g = new Solution();
            while (q > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    System.out.print(g.pop() + " ");
                } else if (qt == 3) {
                    System.out.print(g.getMin() + " ");
                }

                q--;
            }
            System.out.println();
            T--;
        }
        sc.close();
    }
}

class Pair {
    int val;
    int minValue;

    Pair(int val, int minValue) {
        this.val = val;
        this.minValue = minValue;
    }
}

class Solution {
    Stack<Pair> s;

    Solution() {
        s = new Stack<>();
    }

    void push(int x) {
        if (s.isEmpty()) {
            s.push(new Pair(x, x));
        } else {
            int currMin = s.peek().minValue;
            s.push(new Pair(x, Math.min(x, currMin)));
        }
    }

    int pop() {
        if (s.isEmpty()) {
            return -1; 
        }
        return s.pop().val;
    }

    int getMin() {
        if (s.isEmpty()) {
            return -1;
        }
        return s.peek().minValue;
    }
}


