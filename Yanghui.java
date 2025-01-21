package SchoolWork;
import java.util.*;

public class Yanghui {
    public static void main(String[]args){
//        int i,j,k=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]arr=new int[n][n];

        for(int i=0;i<n;i++){
            for(int k=0;k<=(int)((n-i)/2);k++){System.out.print(" ");}

            for(int j=0;j<=i;j++){
                if(j==0 ||j==i){arr[i][j]=1;}
                else {arr[i][j]=arr[i-1][j-1]+arr[i-1][j];}
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}
