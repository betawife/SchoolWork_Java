package SchoolWork;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExample {
    public static void main(String[] args) {
        // 创建一个 Collection 对象
        Collection<String> collection = new ArrayList<>();

        // 向集合中添加元素
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Cherry");
        collection.add("Date");
        collection.add("Elderberry");

        // 使用 Iterator 遍历集合
        System.out.println("使用 Iterator遍历输出:");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // 使用 for-each 循环遍历集合
        System.out.println("\n使用for 循环遍历输出:");
        for (String element : collection) {
            System.out.println(element);
        }
    }
}
