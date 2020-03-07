package J2SE;

import java.util.HashSet;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */
public class HashsetTest {

    public static void main(String[] args) {
        Student2 stu1 = new Student2(2019, "第一人");
        Student2 stu2 = new Student2(2019, "第二人");
        Student2 stu3 = new Student2(2019, "第一人");
        HashSet<Student2> hasStudents = new HashSet<Student2>();
        hasStudents.add(stu1);
        hasStudents.add(stu2);
        hasStudents.add(stu3);
        System.out.println("集合大小:" + hasStudents.size());
        for (Student2 student : hasStudents) {
            System.out.println(student);
        }


    }
}
