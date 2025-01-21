package SchoolWork;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputTime = scanner.nextLine();
        scanner.close();

        String[] timeParts = inputTime.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);

        String period = "AM";
        if (hour >= 12) {
            period = "PM";
            if (hour > 12) {
                hour -= 12;
            }
        } else if (hour == 0) {
            hour = 12;
        }

        System.out.printf("%02d:%02d %s", hour, minute, period);
    }
}