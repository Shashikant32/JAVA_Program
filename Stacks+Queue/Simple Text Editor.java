import java.io.*;
import java.util.*;

class Solution {
    private StringBuilder text;
    private Stack<Operation> history;

    private static class Operation {
        int type; 
        String value; 
        int length; 

        Operation(int type, String value, int length) {
            this.type = type;
            this.value = value;
            this.length = length;
        }
    }

    public Solution() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    public void SimpleTextEditor() {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int i = 0; i < Q; i++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");

            int type = Integer.parseInt(parts[0]);
            switch (type) {
                case 1: // append
                    String toAppend = parts[1];
                    text.append(toAppend);
                    history.push(new Operation(1, toAppend, 0));
                    break;

                case 2: // delete
                    int k = Integer.parseInt(parts[1]);
                    String deleted = text.substring(text.length() - k);
                    text.delete(text.length() - k, text.length());
                    history.push(new Operation(2, deleted, k));
                    break;

                case 3: // print
                    int index = Integer.parseInt(parts[1]) - 1; // Convert to 0-based index
                    System.out.println(text.charAt(index));
                    break;

                case 4: // undo
                    if (!history.isEmpty()) {
                        Operation lastOperation = history.pop();
                        if (lastOperation.type == 1) {
                            // Undo append
                            text.delete(text.length() - lastOperation.value.length(), text.length());
                        } else if (lastOperation.type == 2) {
                            // Undo delete
                            text.append(lastOperation.value);
                        }
                    }
                    break;
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution ob = new Solution();
        ob.SimpleTextEditor();
    }
}
