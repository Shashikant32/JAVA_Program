import java.io.*;
import java.util.*;

public class Main {

       static String hey(String str)
        {
           StringBuilder response = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == 'e') {
                response.append("ee");
            } else {
                response.append(currentChar);
            }
        }
        return response.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String result = hey(str);
        System.out.print(result);        
        System.out.println('\n');
    }
}