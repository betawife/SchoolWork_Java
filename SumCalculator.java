package SchoolWork;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumCalculator extends JFrame {
    private JTextField input1;
    private JTextField input2;
    private JTextField resultField;
    private JButton sumButton;

    public SumCalculator() {
        // 创建窗体和组件
        super("Java程序设计示例");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 输入标签和文本框
        JLabel inputLabel1 = new JLabel("请输入第一个数字:");
        inputLabel1.setBounds(10, 20, 120, 25);
        add(inputLabel1);
        input1 = new JTextField();
        input1.setBounds(140, 20, 100, 25);
        add(input1);

        // 第二个输入标签和文本框
        JLabel inputLabel2 = new JLabel("请输入第二个数字:");
        inputLabel2.setBounds(10, 60, 120, 25);
        add(inputLabel2);
        input2 = new JTextField();
        input2.setBounds(140, 60, 100, 25);
        add(input2);

        // 结果标签和文本框
        JLabel resultLabel = new JLabel("求和结果=");
        resultLabel.setBounds(10, 100, 80, 25);
        add(resultLabel);
        resultField = new JTextField();
        resultField.setBounds(90, 100, 100, 25);
        resultField.setEditable(false);
        add(resultField);

        // 求和按钮
        sumButton = new JButton("求和");
        sumButton.setBounds(300, 100, 80, 25);
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(input1.getText());
                    double num2 = Double.parseDouble(input2.getText());
                    double sum = num1 + num2;
                    resultField.setText(String.valueOf(sum));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "请输入有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(sumButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SumCalculator();
    }
}
