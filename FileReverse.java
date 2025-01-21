package SchoolWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileReverse {
    private ArrayList<String> lines = new ArrayList<>();

    // 读取文件的方法
    public void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件出错: " + e.getMessage());
        }
    }

    // 写入文件的方法
    public void writeFile(String filePath) {
        Collections.reverse(lines); // 将内容倒序排列
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // 写入换行符
            }
        } catch (IOException e) {
            System.out.println("写入文件出错: " + e.getMessage());
        }
    }
}
