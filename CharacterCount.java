package SchoolWork;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        // 删除中文字符
        String filteredInput = input.replaceAll("[\\u4e00-\\u9fa5]", "");

        // 转换为小写并统计字母频率
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
        for (char c : filteredInput.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        // 输出结果
        for (char key : frequencyMap.keySet()) {
            System.out.print(key + "=" + frequencyMap.get(key) + "  ");
        }
    }
}