package J2SE;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */
public class CompareTest {


    public static void main(String[] args) { //定义一个学生数据库
//        Student[] allStudents = new Student[3]; //初始化学生数据库 allStudents[0] = new Student(1,"a");
//        allStudents[0] = new Student(2, "b");
//        allStudents[1] = new Student(3, "c");
//        allStudents[2] = new Student(4, "d");
//        for (int i = 0; i <allStudents.length; i++) {
//            allStudents[i].setAge(i * 10);
//        } //不同点
//        Arrays.sort(allStudents);
//        //通过student内部的compareTo()方法比较排序。
//        // 显示学生信息
//        System.out.println("年龄" + "\t姓名");
//        for (int i = 0; i < allStudents.length; i++) {
//            System.out.print(allStudents[i]);
//        }


        Student2[] allStudents = new Student2[3]; //初始化学生数据库 allStudents[0] = new Student2(1,"a");
        allStudents[0] = new Student2(2, "b");
        allStudents[1] = new Student2(3, "c");
        allStudents[2] = new Student2(4, "d");
        for (int i = 0; i < allStudents.length; i++) {
            allStudents[i].setAge(i * 10);
        } //显示学生信息
        System.out.println("年龄" + "\t姓名");
        for (int i = 0; i < allStudents.length; i++) {
            System.out.print(allStudents[i]);
        }

        Arrays.sort(allStudents, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });//不同点,
        // 通过 <T> void java.util.Arrays.sort(T[] a, Comparator<? super T> c)来调用自己构建的排序实现类 //显示学生信息
        System.out.println("年龄" + "\t姓名");
        for (int i = 0; i < allStudents.length; i++) {
            System.out.print(allStudents[i]);

        }
    }
}