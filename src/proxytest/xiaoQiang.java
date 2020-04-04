package proxytest;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class xiaoQiang implements Person {
    private String name;
    private String house;

    public xiaoQiang(String name, String house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public void buy() {
        System.out.println(name + "买了" + house);
    }

    @Override
    public void buy1() {
        System.out.println("我是你爸爸");
    }
}
