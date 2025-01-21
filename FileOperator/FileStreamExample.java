package SchoolWork.FileOperator;

import java.io.*;

public class FileStreamExample {
    public static void main(String[] args) {
        String fileName = "myfile.txt";
        String content = "Hello, this is a test using FileOutputStream and FileInputStream.";

        // 写入文件
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(content.getBytes());
            System.out.println("内容已写入文件: " + fileName);
        } catch (IOException e) {
            System.out.println("写入文件时发生错误: " + e.getMessage());
        }

        // 读取文件
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int data;
            System.out.println("文件内容:");
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("读取文件时发生错误: " + e.getMessage());
        }
    }
}

