package SchoolWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        // 使用 HashSet 存储互不相同的随机数
        HashSet<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();

        // 生成 10 个互不相同的随机数
        while (randomNumbers.size() < 10) {
            int num = random.nextInt(101) + 100; // 生成 100 到 200 的随机数
            randomNumbers.add(num);
        }

        // 将 HashSet 转为 ArrayList 以便排序和查找
        ArrayList<Integer> numberList = new ArrayList<>(randomNumbers);

        // 找到最大值和最小值
        int max = Collections.max(numberList);
        int min = Collections.min(numberList);

        // 输出结果
        System.out.println("生成的随机数是：" + numberList);
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
    }
}
