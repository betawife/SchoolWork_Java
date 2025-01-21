package SchoolWork;
import javax.swing.*;
import java.lang.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIdemo extends JFrame{

        private JTextField f1, f2, resultf;
        private JButton b1;

    public GUIdemo() {
            super("求和计算器:");
            setLayout(new FlowLayout());
            //组件创建
            f1 = new JTextField(10);
            f2 = new JTextField(10);
            resultf = new JTextField(10);
            resultf.setEditable(false);
            b1=new JButton("求和");
            //添加到窗口
            add(new JLabel("x1:"));
            add(f1);
            add(new JLabel("x2:"));
            add(f2);
            add(resultf);
            add(b1);
            //设置按钮监听器
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int x1 = Integer.parseInt(f1.getText());
                        int x2 = Integer.parseInt(f2.getText());
                        int sum = x1 + x2;
                        resultf.setText(String.valueOf(sum));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "请输入有效数字：", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            //设置窗口属性
            setSize(300, 150);
            setVisible(true);
    }
    public static void main(String[]args) {GUIdemo G1=new GUIdemo();}
}
