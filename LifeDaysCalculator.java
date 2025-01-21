package SchoolWork;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LifeDaysCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入出生日期
        System.out.println("请输入您的出生日期 (格式：YYYY-MM-DD)：");
        String birthDateInput = scanner.nextLine();

        try {
            // 将输入的出生日期解析为 LocalDate
            LocalDate birthDate = LocalDate.parse(birthDateInput);

            // 获取当前日期
            LocalDate currentDate = LocalDate.now();

            // 检查出生日期是否在当前日期之前
            if (birthDate.isAfter(currentDate)) {
                System.out.println("出生日期不能晚于今天，请重新输入！");
                return;
            }

            // 计算总天数
            long totalDays = ChronoUnit.DAYS.between(birthDate, currentDate);

            // 计算年份和天数（可选）
            Period period = Period.between(birthDate, currentDate);
            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();

            // 输出结果
            System.out.println("从您的出生日期到今天，您已经走过了：" + totalDays + " 天！");
            System.out.println("这大约是 " + years + " 年 " + months + " 个月 " + days + " 天。");
        } catch (Exception e) {
            System.out.println("输入的日期格式有误，请使用 YYYY-MM-DD 格式！");
        }
    }
}
