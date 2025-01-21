package SchoolWork;

public class Java_2 {
    public static void main (String args[]) {
        try {
            Sleep a = new Sleep ();
            Thread t = new Thread (a);

            //*********Found**********
            t.start();  // 启动线程

            t.join();  // 等待线程结束

            int j = a.i;

            System.out.println("j=" + j + ",a.i=" + a.i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//*********Found**********
class Sleep implements Runnable { // 实现Runnable接口
    int i;

    public void run() {
        try {
            //*********Found**********
            Thread.sleep(50);  // 休眠50毫秒

            i = 10;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

