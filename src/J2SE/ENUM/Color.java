package J2SE.ENUM;

public enum Color {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOW("黄色", 4);
    //  成员变量
    private String name;
    private int index;

    //  构造方法
    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //  普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    //  get  set  方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {


        System.out.println( Color.getName(1));

    }


}