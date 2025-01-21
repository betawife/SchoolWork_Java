package SchoolWork;
import java.io.*;

public class FileStream {
    public static void main(String[]args){
        String fname="myfile.txt";
        String content ="filecontent";
        try(FileOutputStream fos=new FileOutputStream(fname)){
            fos.write(content.getBytes());
            System.out.println("内容以写入文件"+fname);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        try(FileInputStream fis= new FileInputStream(fname)){
            int data;
            System.out.println("文件内容：");
            while((data=fis.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
