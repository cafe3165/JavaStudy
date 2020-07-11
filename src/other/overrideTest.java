package other;

public class overrideTest {

    class A{
        int a;
        public  A(){
            a=1;
        }

        @Override
        public String toString() {

            return String.valueOf(a)+"777";
        }
    }

    public static void main(String[] args) {
        overrideTest o=new overrideTest();
        overrideTest.A a=o.new A();
        System.out.println(a.toString());
    }
}
