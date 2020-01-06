package designPattern.deco;

public class TShirts extends Finery {
    @Override
    public void show(){
        System.out.println("T-shirts");
        super.show();
    }
}
