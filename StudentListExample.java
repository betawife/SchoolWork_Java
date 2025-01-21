package SchoolWork;

import java.util.ArrayList;
import java.util.List;

class Studentinfo {
    private String id;    // 学号
    private String name;  // 姓名

    // 构造方法
    public Studentinfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // 获取学号
    public String getId() {
        return id;
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 重写 toString 方法，方便输出学生信息
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "'}";
    }
}

public class StudentListExample {
    public static void main(String[] args) {
        // 创建一个 List 类型的对象
        List<Studentinfo> students = new ArrayList<>();

        // 加入3个学生信息
        students.add(new Studentinfo("1001", "李华"));
        students.add(new Studentinfo("1002", "赵四"));
        students.add(new Studentinfo("1003", "王五"));

        // ① 输出所有学生信息
        System.out.println("所有学生:");
        for (Studentinfo student : students) {
            System.out.println(student);
        }

        // ② 按学号和姓名查找并输出学生信息
        System.out.println("\n由学号和姓名搜索信息：");
        String searchId = "1002";
        String searchName = "赵四";
        for (Studentinfo student : students) {
            if (student.getId().equals(searchId) && student.getName().equals(searchName)) {
                System.out.println("找到信息: " + student);
            }
        }

        // ③ 在第二个学生前插入一个新的学生
        System.out.println("\n在第二个学生前插入一条信息:");
        students.add(1, new Studentinfo("1004", "李娟"));
        for (Studentinfo student : students) {
            System.out.println(student);
        }

        // ④ 删除最后一个学生
        System.out.println("\n删除最后一位学生:");
        if (!students.isEmpty()) {
            students.remove(students.size() - 1);
        }
        for (Studentinfo student : students) {
            System.out.println(student);
        }
    }
}
