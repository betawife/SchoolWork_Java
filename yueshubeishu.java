package SchoolWork;
import java.util.Scanner;
public class yueshubeishu {
    public static void main(String []args){
        int a,b=0;
        System.out.print("请输入两个整数：");
        Scanner sc =new Scanner(System.in);
        a=sc.nextInt();
        b= sc.nextInt();
        sc.close();
        int a2=a,b2=b;
        int c=a%b;
        while(c!=0){
            a=b;b=c;
            c=a%b;
        }
        System.out.printf("最大公约数为：%d",b);
        System.out.println();
        int i=(a2*b2)/b;
       System.out.printf("最小公倍数为：%d",i);
    }
}
