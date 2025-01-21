package SchoolWork;

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        double y = calculateElectricityBill(x);
        System.out.println(y);
    }

    public static double calculateElectricityBill(int x) {
        double y;
        if (x <= 100) {
            y = x * 0.3;
        } else if (x <= 200) {
            y = x * 0.4;
        } else if (x <= 300) {
            y = x * 0.5;
        } else {
            y = x * 0.8;
        }
        return y;
    }
}
