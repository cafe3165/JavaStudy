package J2SE;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */
//在内部实现comparable接口，指定排序依据
public class Student implements Comparable<Student> {
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

    public Student(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    } /* (non Javadoc)
     * @Title: compareTo
     * @Description: 实现comparaTor（）方法，来指定排序依据
     * @param stu
     * @return
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */

    @Override
    public int compareTo(Student stu) {
//        return this.getName().compareTo(stu.getName());
        return stu.getName().compareTo(this.getName());
        //定义成升序
    }

    @Override
    public String toString() {
        return age + "\t" + name + "\n";

    }

}