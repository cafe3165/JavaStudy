package J2SE;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */

public class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public int compareTo(Object o) {
        Person p=(Person)o;
//        return this.age-p.age;
        return this.name.compareTo(p.name);
//        return 0;
    }
}
