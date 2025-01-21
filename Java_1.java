package SchoolWork;

public class Java_1 implements Runnable {  //*********Found**********
    private int x = 0;
    private int y = 0;

    public static void main(String[] args) {
        Java_1 r = new Java_1();
        //*********Found**********
        Thread t = new Thread(r);
        t.start();
    }

    public void run() {
        //*********Found**********
        int k = 0;
        for (;;) {
            x++;
            //*********Found**********
            y = x;
            k++;
            if (k > 5) break;  //退出for循环
            System.out.println("x=" + x + ",y=" + y);
        }
    }
}
