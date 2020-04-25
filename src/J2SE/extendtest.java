package J2SE;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class extendtest extends Person{
    public extendtest(String name, int age) {
        super(name, age);
    }
    public int call2(){
        return this.getAge();
    }
//    public String call2(){
//        return this.getName();
//    }

    public static void main(String[] args) {
//        Person p=new extendtest("aaa",1);
//        p.call();
        extendtest e=new extendtest("xxx",12);
    }
}
