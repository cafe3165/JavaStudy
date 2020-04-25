package J2SE.Serial;

import lombok.Data;

import java.io.*;

/**
 * Author:cafe3165
 * Date:2020-04-22
 * https://www.cnblogs.com/vinozly/p/5171227.html
 */
@Data
public class TestSerialization implements Serializable {
    private static final long serialVersionUID = 1213748575985302395L;
    private transient int num;

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeObject(num);
        System.out.println("writeObject of " + this.getClass().getName());
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        num = (Integer) s.readObject();
        System.out.println("readObject of " + this.getClass().getName());
    }

    public static void main(String[] args) {
        TestSerialization test = new TestSerialization();
        test.setNum(10);
        System.out.println("序列化之前的值："+test.getNum());
        // 写入
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream("D:\\test.tmp"));
            outputStream.writeObject(test);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // 读取
        try
        {
            ObjectInputStream oInputStream = new ObjectInputStream(
                    new FileInputStream("D:\\test.tmp"));
            try
            {
                TestSerialization aTest = (TestSerialization) oInputStream.readObject();
                System.out.println("读取序列化后的值："+aTest.getNum());
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
