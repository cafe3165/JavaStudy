package J2SE;

import java.util.Objects;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */


//这里并未实现comparable接口
public class Student2 {
    private int age;
    private String name;

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

    public Student2(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + "\t" + name + "\n";

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Student2)) {
            return false;
        }
        Student2 stu = (Student2) obj;
        return Objects.equals(name, stu.name) && this.age == stu.age;
    }


}