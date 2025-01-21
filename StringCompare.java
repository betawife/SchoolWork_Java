package SchoolWork;

import java.util.concurrent.Callable;

public class StringCompare {
    public static void main(String [] args){
        String [] Country={"America","Netherlands","Canada","Russia","France"};
        String temp = "";
    for(int i=0;i<4;i++){
        for(int j=0;j<4-i;j++){
            if(Country[j].compareTo(Country[j+1])>0){
               temp=Country[j+1];
               Country[j+1]=Country[j];
               Country[j]=temp;
                    }
                }
            }
        for(int i=0;i<=4;i++) {
           System.out.printf("%s",Country[i]+"\n");

        }
    }
    }

