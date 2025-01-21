package SchoolWork;
import java.util.Scanner;
public class sushu {
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        int n=0,m=0;int sum=0;
        n=sc.nextInt();
        m=sc.nextInt(); sc.close();
        for(int i=n;i<=m;i++){
            int j=2;
            while(i%j!=0){j++;}
            if(j>=i){sum+=i;}
        }
        System.out.println(sum);
    }
}
