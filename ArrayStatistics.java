package SchoolWork;

public class ArrayStatistics {
    // 方法用于计算数组元素的平均值、最大值和最小值
    public void calculateArrayStats(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空或长度为0，无法计算统计数据。");
            return;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            sum += num;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        double average = (double) sum / arr.length;
        System.out.println("平均值： " + average);
        System.out.println("最大值： " + max);
        System.out.println("最小值： " + min);
    }

    public static void main(String[] args) {
        // 创建ArrayStatistics类的实例
        ArrayStatistics stats = new ArrayStatistics();

        // 定义一个整型数组
        int[] array = {1, 2, 3, 4, 5};

        // 调用calculateArrayStats方法来计算并输出数组的统计数据
        stats.calculateArrayStats(array);
    }
}