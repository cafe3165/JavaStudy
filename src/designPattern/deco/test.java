package designPattern.deco;

import java.math.BigInteger;

public class test {

    public static void main(String[] args) {
        Person xm=new Person("小明");
        System.out.println("第一种装扮");
        BigTrouser bt=new BigTrouser();
        TShirts ts=new TShirts();
        bt.Decorate(ts);
        bt.show();
    }

}
