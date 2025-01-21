package SchoolWork;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphT extends Frame{

         Label l1,l2;
         JRadioButton B1,B2;ButtonGroup BG;       //swing组件中的JRadioButton，适配ButtonGroup
         Panel panel =new Panel();
         GraphT(String title){                    //构造方法
             super(title);                        //传参标题给窗体
             l1=new Label();                      //标签实例化与设置
             l1.setBackground(Color.PINK);
             l1.setText("anny TV");
             l2=new Label();
             l2.setBackground(Color.GREEN);
             l2.setText("Vedal987 TV");
             B1=new JRadioButton("vote for anny");  //button实例化与设置
             B1.setActionCommand("投给Anny");             //button的命令名
             B2=new JRadioButton("vote for coldfish");
             B2.setActionCommand("投给coldfish");
             BG=new ButtonGroup();
             BG.add(B1);
             BG.add(B2);
             B1.addActionListener(new ButtonActionListener()); //为Button添加监听器
             B2.addActionListener(new ButtonActionListener());
             panel.add(l1);panel.add(l2);
             panel.add(B1);panel.add(B2);
             add(panel);
             setSize(200,200);
             setVisible(true);
         }
         class ButtonActionListener implements ActionListener{  //行为监听器接口的实现
             @Override
             public void actionPerformed(ActionEvent e){
                 System.out.println("Button is clicked.");
             }

         }

}
