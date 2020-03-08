package J2SE;

import java.io.*;

/**
 * Author:cafe3165
 * Date:2020-03-08
 */
public class SerialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeUser();
        DeSerializeUser();
    }

    //序列化方法
    private static void SerializeUser() throws FileNotFoundException, IOException {
        User user = new User();
        user.setName("Java的架构师技术栈");
        user.setAge(24);
        //序列化对象到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(user);
        oos.close();
        System.out.println("序列化对象成功");
        user.setAge(18);
    }

    //反序列化方法
    private static void DeSerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User) ois.readObject();
        System.out.println("反序列化对象成功" + newUser.toString());
    }
}
