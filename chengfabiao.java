package SchoolWork;

public class chengfabiao {
    public static void main(String[]args){
        int i,j=1;int product=0;
        for(i=1;i<=9;i++){
            for(j=1;j<=i;j++){
                product=i*j;
                System.out.printf("%d*%d=%d ",i,j,product);
            }
            System.out.print("\n");
        }
    }
}
