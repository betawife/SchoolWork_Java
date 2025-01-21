package SchoolWork;

public abstract class GoodsLab {
    public int goodsnum;
    public String goodsname;
    public double goodsvalue;

    public GoodsLab(){
        this.goodsname=goodsname;
        this.goodsnum=goodsnum;
        this.goodsvalue=goodsvalue;

    }
    public abstract double getValue();
    public abstract void setValue(double value);
    public abstract void showInfo();
}

