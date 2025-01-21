package SchoolWork;

public class ThreadTest {
    public static void main(String[]args){
        Thread t1=new Thread(new Hello());
        t1.start();
    }

}
class Hello implements Runnable{
    int i=0;
    public void run(){
        while(true){System.out.println("hello"+(i+1));i++;
        if(i==5)break;
        }
    }
}
