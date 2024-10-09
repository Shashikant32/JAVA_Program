import java.util.*;

class Solution {
    private static final int SIZE = 1000; // Size of the hash table
    private List<Integer>[] table;

    public Solution() {
        table = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE; // Hash function
    }

    public void add(int key) {
        int index = hash(key);
        if (!table[index].contains(key)) {
            table[index].add(key); // Add key if it doesn't exist
        }
    }

    public void remove(int key) {
        int index = hash(key);
        table[index].remove(Integer.valueOf(key)); // Remove key if it exists
    }

    public boolean contains(int key) {
        int index = hash(key);
        return table[index].contains(key); // Check if the key exists
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // Contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // Remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}
