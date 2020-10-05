package J2SE;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author:cafe3165
 * Date:2020-09-19
 */
public class FileTest {
    public static void main(String args[]) throws IOException {
        File file = new File("Hello1.txt");
        // 创建文件
        file.createNewFile();
        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);
        // 向文件写入内容
        writer.write("This\n is\n an\n example\n");
        writer.flush();
        writer.close();
        // 创建 FileReader 对象
        FileReader fr = new FileReader(file);
        char[] a = new char[50];

        fr.read(a); // 读取数组中的内容
        String s=new String(a);
        System.out.println(s);
        for (char c : a) {
            System.out.print(c); // 一个一个打印字符
        }
        fr.close();
    }
}
