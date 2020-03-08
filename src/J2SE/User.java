package J2SE;

import java.io.Serializable;

/**
 * Author:cafe3165
 * Date:2020-03-08
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
