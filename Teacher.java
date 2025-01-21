package SchoolWork;

public class Teacher {
    public String name;
    public int Id;
    public Teacher(String name,int Id)
    {
        this.name=name;
        this.Id=Id;
    }
    public  void showinfo() {
        System.out.println("姓名："+this.name);
        System.out.println("工号："+this.Id);
    }
}

