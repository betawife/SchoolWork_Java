package SchoolWork;
import java.util.Random;
public class Randomnum {
    public static void main(String[] args){
        int []randomnum =new int[10];
        for(int i=0;i<10;i++){
            randomnum[i]= (int) (Math.random()*100+100);
        }
        int temp=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9-i;j++){
                if(randomnum[j]>randomnum[j+1]){
                    temp=randomnum[j];
                    randomnum[j]=randomnum[j+1];
                    randomnum[j+1]=temp;
                }
            }
        }
        System.out.println("介于100~200的10个随机整数：");
        for(int i=0;i<=9;i++){
            System.out.printf("%d ",randomnum[i]);
        }
    }
}
