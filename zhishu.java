package SchoolWork;

public class zhishu {
    public static void main(String [] args){
        int i=2;
        for(i=2;i<=100;i++){
            int j=2;
            while(j<=i)
            {
                if(i%j==0){break;}
                else{j++;}
            }
            if(j>=i){
                System.out.printf("%d ",i);
            }
        }
    }
}
