import java.io.*;
import java.util.*;

public class Main {
    static String[] keypad = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    static void printKPC(String ques, String outputSoFar) {
        if (ques.length() == 0) {
            System.out.println(outputSoFar);
            return;
        }

        char currentDigit = ques.charAt(0);
        String characters = keypad[currentDigit - '0'];

        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            printKPC(ques.substring(1), outputSoFar + ch);
        }
    }

    public static void printKPC(String ques) {
        printKPC(ques, "");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        printKPC(str);
    }
}