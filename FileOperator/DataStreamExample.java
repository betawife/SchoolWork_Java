package SchoolWork.FileOperator;

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        String fileName = "datafile.txt";

        // 写入数据
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(42);
            dos.writeDouble(3.14);
            dos.writeUTF("Hello, DataOutputStream!");
            System.out.println("数据已写入文件: " + fileName);
        } catch (IOException e) {
            System.err.println("写入文件时发生错误: " + e.getMessage());
        }

        // 读取数据
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            String stringValue = dis.readUTF();

            System.out.println("读取的内容:");
            System.out.println("整数: " + intValue);
            System.out.println("浮点数: " + doubleValue);
            System.out.println("字符串: " + stringValue);
        } catch (IOException e) {
            System.err.println("读取文件时发生错误: " + e.getMessage());
        }
    }
}
