package SchoolWork;

class Racer implements Runnable {
    private String name;
    private int distance;
    private static final int TOTAL_DISTANCE = 100;
    private boolean isRabbit;

    public Racer(String name, boolean isRabbit) {
        this.name = name;
        this.isRabbit = isRabbit;
    }

    @Override
    public void run() {
        for (distance = 1; distance <= TOTAL_DISTANCE; distance++) {
            try {
                if (isRabbit && distance % 20 == 0) {
                    System.out.println(name + " 停下来休息一会儿...");
                    Thread.sleep(1000); // 模拟兔子休息
                }
                System.out.println(name + " 已跑 " + distance + " 米");
                Thread.sleep(100); // 模拟跑步速度
            } catch (InterruptedException e) {
                System.err.println(name + " 被中断！");
            }
        }
        System.out.println(name + " 到达终点！");
    }
}

public class RabbitTurtleRace {
    public static void main(String[] args) {
        Thread rabbit = new Thread(new Racer("兔子", true));
        Thread turtle = new Thread(new Racer("乌龟", false));

        System.out.println("比赛开始！");
        rabbit.start();
        turtle.start();
    }
}
