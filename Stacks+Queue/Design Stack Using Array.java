import java.util.*;

class Main {
    public static void main(String[] args) {
        StackUsingArray obj = new StackUsingArray();
        Scanner sc = new Scanner(System.in);
        int q;
        q = sc.nextInt();
        while (q-- > 0) {
            int x;
            x = sc.nextInt();
            if (x == 1) {
                int y;
                y = sc.nextInt();
                obj.push(y);
            }
            if (x == 2) {
                System.out.println(obj.peek());
            }
            if (x == 3) {
                obj.pop();
            }
            if (x == 4) {
                obj.display();
                System.out.println();
            }
        }
        sc.close();
    }
}

class StackUsingArray {
    private ArrayList<Integer> st;

    StackUsingArray() {
        st = new ArrayList<>();
    }

    public void push(int x) {
        st.add(x);
    }

    public int peek() {
        if (st.isEmpty()) {
            return -1;
        } else {
            return st.get(st.size() - 1);
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            st.remove(st.size() - 1);
        }
    }

    public void display() {
        if (st.isEmpty()) {
            return;
        }
        for (int i = st.size() - 1; i >= 0; i--) {
            System.out.print(st.get(i) + " ");
        }
    }
}
