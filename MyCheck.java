package SchoolWork;

import java.awt.*;
import java.awt.event.*;

/*---在（1）处进行类声明：类名为MyCheck，继承自Frame类---*/
public class MyCheck extends Frame { //（1）

    public MyCheck(){
        super("GUI程序设计实验");
        /*---在（2）处创建面板对象，并设置其布局管理方式为FlowLayout---*/
        Panel p = new Panel(); //（2）
        Checkbox cbx = new Checkbox("isPassed");
        /*---在（3）处完成两个功能：向面板中加入组件cbx，为组件cbx注册监听器。此处填写两行语句---*/
        p.add(cbx); //（3）第一行
        cbx.addItemListener(new ItemListener() { //（3）第二行
            @Override
            public void itemStateChanged(ItemEvent e){
                System.out.println("Item: " + (e.getStateChange() == ItemEvent.SELECTED ? "Selected" : "Deselected"));
            }
        });
        add(p);

        /*---在（4）处设置窗体的属性：设置大小为（250，100），设置为可见。此处填写两行语句---*/
        setSize(250, 100); //（4）第一行
        setVisible(true); //（4）第二行
    }

    public static void main(String[] args){
        new MyCheck();
    }

    /*---在（5）处声明内部类的类头：类名自定义---*/
    //（5）
}
