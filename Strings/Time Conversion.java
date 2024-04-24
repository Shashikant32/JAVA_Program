import java.util.*;

public class Main {
    static void timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String minuteAndSecond = s.substring(3, 8);
        String AMPM = s.substring(8);

        if (AMPM.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        String hourStr = String.format("%02d", hour);
        String militaryTime = hourStr + ":" + minuteAndSecond;
        System.out.println(militaryTime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        timeConversion(str);
        sc.close();
    }
}
