package SchoolWork;
import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int c = (f - 32) * 5 / 9;
        System.out.println(c);
    }
}