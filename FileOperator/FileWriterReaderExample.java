package SchoolWork.FileOperator;

import java.io.*;

public class FileWriterReaderExample {
    public static void main(String[] args) {
        String fileName = "myfile.txt";
        String content = "Hello, this is a test using FileWriter and FileReader.";

        // 写入文件
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("内容已写入文件: " + fileName);
        } catch (IOException e) {
            System.err.println("写入文件时发生错误: " + e.getMessage());
        }

        // 读取文件
        try (FileReader reader = new FileReader(fileName)) {
            int data;
            System.out.println("文件内容:");
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.err.println("读取文件时发生错误: " + e.getMessage());
        }
    }
}
