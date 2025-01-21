package SchoolWork.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookManager extends JFrame {
    private ArrayList<Book> books = new ArrayList<>();
    private JTextField titleField, authorField, yearField, priceField;
    private JTextArea displayArea;

    public BookManager() {
        setTitle("图书管理系统");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 创建面板和组件
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("书名:"));
        titleField = new JTextField();
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("作者:"));
        authorField = new JTextField();
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("出版年份:"));
        yearField = new JTextField();
        inputPanel.add(yearField);
        inputPanel.add(new JLabel("价格:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        JButton addButton = new JButton("添加图书");
        inputPanel.add(addButton);
        JButton queryButton = new JButton("查询图书");
        inputPanel.add(queryButton);
        JButton updateButton = new JButton("修改图书");
        inputPanel.add(updateButton);
        JButton deleteButton = new JButton("删除图书");
        inputPanel.add(deleteButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // 添加按钮事件监听器
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryBook();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBook();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
    }

    //添加图书，包含异常处理
    private void addBook() {
        try {
            String title = titleField.getText();
            String author = authorField.getText();
            int year = Integer.parseInt(yearField.getText());
            double price = Double.parseDouble(priceField.getText());
            Book book = new Book(title, author, year, price);
            books.add(book);
            displayArea.append("添加成功: " + book.toString() + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void queryBook() {
        displayArea.append("查询结果:\n");
        for (Book book : books) {
            displayArea.append(book.toString() + "\n");
        }
    }

    private void updateBook() {
        try {
            String title = titleField.getText();
            String author = authorField.getText();
            int year = Integer.parseInt(yearField.getText());
            double price = Double.parseDouble(priceField.getText());
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    book.setAuthor(author);
                    book.setYear(year);
                    book.setPrice(price);
                    displayArea.append("更新成功: " + book.toString() + "\n");
                    return;
                }
            }
            displayArea.append("未找到该图书\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入有效的数字", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteBook() {
        String title = titleField.getText();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                displayArea.append("删除成功: " + book.toString() + "\n");
                return;
            }
        }
        displayArea.append("未找到该图书\n");
    }
}
