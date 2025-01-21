package SchoolWork;
import java.util.Scanner;

public class NumSum {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n < 1 || n > 100) {
                System.out.println("error");
                return;
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num < 0 || num >= 800) {
                    System.out.println("error");
                    return;
                }
                sum += num;
            }
            System.out.println(sum);
        }

}
