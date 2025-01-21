package SchoolWork;

class TicketWindow implements Runnable {
    private int tickets = 50; // 总票数
    private final Object lock = new Object(); // 锁对象

    @Override
    public void run() {
        while (true) {
            synchronized (lock) { // 同步代码块
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " 正在售票，剩余票数：" + (tickets - 1));
                    tickets--;
                    try {
                        Thread.sleep(100); // 模拟售票时间
                    } catch (InterruptedException e) {
                        System.err.println(Thread.currentThread().getName() + " 被中断！");
                    }
                } else {
                    System.out.println("票已售罄！");
                    break;
                }
            }
        }
    }
}

public class TicketSales {
    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow();

        Thread window1 = new Thread(ticketWindow, "窗口1");
        Thread window2 = new Thread(ticketWindow, "窗口2");
        Thread window3 = new Thread(ticketWindow, "窗口3");

        System.out.println("售票开始！");
        window1.start();
        window2.start();
        window3.start();
    }
}

