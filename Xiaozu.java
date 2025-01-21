package SchoolWork;
import java.util.Scanner;
import java.util.Arrays;

public class Xiaozu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 != 0) {
            System.out.println("odd number");
            return;
        }
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }
        Arrays.sort(ids);
        for (int i = 0; i < n / 2; i++) {
            System.out.println(ids[i] + " " + ids[n - 1 - i]);
        }
    }
}