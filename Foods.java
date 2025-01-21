package SchoolWork;
import java.util.Scanner;

public class Foods extends GoodsLab{

        public String productiondata;
        public int durance;
        public String conposition;

        public void setProductiondataDurance ( int Durance){
            this.durance = Durance;
        }
        public String getName () {
            return this.goodsname;
        }
        public void setName (String Name){
            this.goodsname = Name;
        }
        @Override
        public double getValue () {
            return this.goodsvalue;
        }
        public void setValue ( double value){
            this.goodsvalue = value;
        }
        public void showInfo () {

            System.out.println(this.goodsvalue + this.goodsname + this.goodsnum + this.conposition + this.durance);
        }
    public static void main(String []args) {
        Foods f2=new Foods();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入商品名：");
        String Name = sc.nextLine();
        System.out.println("请输入价格：");
        Double value = sc.nextDouble();
        f2.setValue(value);
        f2.setName(Name);
        f2.durance=360;
        f2.conposition="绿茶，白水，甜味素";
        f2.goodsnum=1001;
        f2.showInfo();
    }
}